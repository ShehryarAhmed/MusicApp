package com.example.android.cardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.cardview.model.AlbumDetail;

import java.util.List;
/**
 * Created by android on 3/5/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
    private  Context mContext;
    private List<AlbumDetail> list;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTitle;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.recycler_view);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Toasr", Toast.LENGTH_SHORT).show();
        }
    }
    public MyAdapter(Context context,String[] myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(mContext).inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        v.setFocusable(true);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
