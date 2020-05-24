package com.example.musicapp.roompojo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MusicStoreDao {
    @Insert
    void insert (MusicStore musicStore);

    @Update
    void update (MusicStore musicStore);

    @Delete
    void delete (MusicStore musicStore);

    @Query("SELECT * FROM music_store")
    LiveData< List<MusicStore>> getAllMusics();
}
