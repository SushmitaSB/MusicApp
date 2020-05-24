package com.example.musicapp.roompojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "music_store")
public class MusicStore {
    @PrimaryKey(autoGenerate = true)
    private int music_id;
    private String title;
    private String artist;
    private String songLocation;

    public MusicStore(String title, String artist, String songLocation) {
        this.title = title;
        this.artist = artist;
        this.songLocation = songLocation;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongLocation() {
        return songLocation;
    }

    public void setSongLocation(String songLocation) {
        this.songLocation = songLocation;
    }
}
