package com.example.android.cardview.model;

/**
 * Created by android on 3/5/2017.
 */

public class Album {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public Album(){}

    public Album(String name, int numOfSongs, int thumbnail) {
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
