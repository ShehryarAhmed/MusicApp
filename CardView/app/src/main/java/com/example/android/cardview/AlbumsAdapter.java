package com.example.android.cardview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.cardview.model.Album;

import java.util.List;

/**
 * Created by android on 3/5/2017.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;
    private List<Album> albumList;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTitle;
        public TextView mCount;

        public ImageView mThumbnail;
        public ImageView mOverflow;


        public ViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.title);
            mCount = (TextView) v.findViewById(R.id.count);
            mThumbnail = (ImageView) v.findViewById(R.id.thumbnail);
            mOverflow = (ImageView) v.findViewById(R.id.overflow);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Toasr", Toast.LENGTH_SHORT).show();
        }
    }

    public AlbumsAdapter(Context context, List<Album> lists) {
        mContext = context;
        albumList = lists;
    }

    @Override
    public AlbumsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_albumcard, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AlbumsAdapter.ViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.mTitle.setText(album.getName());
        holder.mCount.setText(album.getNumOfSongs() + " Songs");

        Glide.with(mContext).load(album.getThumbnail()).into(holder.mThumbnail);
        holder.mOverflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopMenu(holder.mOverflow);
            }
        });
    }

    private void showPopMenu(View view) {
        PopupMenu popup = new PopupMenu(mContext, view);

        MenuInflater inflater = popup.getMenuInflater();

        inflater.inflate(R.menu.menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener{
        public MyMenuItemClickListener() {

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }

    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
