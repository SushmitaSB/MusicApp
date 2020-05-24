package com.example.musicapp.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicapp.roompojo.MusicStore;
import com.example.musicapp.viewmodel.MusicStoreViewModel;

public class GetMusicFromStorage {
    Context context;
    MusicStoreViewModel musicStoreViewModel;
    public GetMusicFromStorage(){

    }
    public GetMusicFromStorage(Context context, MusicStoreViewModel musicStoreViewModel){
        this.context = context;
        this.musicStoreViewModel = musicStoreViewModel;
    }
    public void GetMusic(){
        ContentResolver contentResolver = context.getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //musicStoreViewModel = ViewModelProviders.of(context).get(MusicStoreViewModel.class);
        Cursor songCursor = contentResolver.query(songUri, null, null,null,null);
        if (songCursor != null && songCursor.moveToFirst()){
            int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int location = songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);

            do{
                String stringTitle = songCursor.getString(songTitle);
                String stringartist = songCursor.getString(songArtist);
                String stringLocation = songCursor.getString(location);
                MusicStore musicStore = new MusicStore(stringTitle, stringartist,stringLocation);
                musicStoreViewModel.insert(musicStore);
            }while (songCursor.moveToNext());
        }
    }
}
