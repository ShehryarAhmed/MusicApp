package com.example.android.cardview.model;

/**
 * Created by android on 3/5/2017.
 */

public class AlbumDetail {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public AlbumDetail(){}

    public AlbumDetail(int numOfSongs, String name, int thumbnail) {
        this.numOfSongs = numOfSongs;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}
