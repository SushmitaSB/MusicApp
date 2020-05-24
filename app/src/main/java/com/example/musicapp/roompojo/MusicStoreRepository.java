package com.example.musicapp.roompojo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MusicStoreRepository {

    private MusicStoreDao musicStoreDao;
    private LiveData<List<MusicStore>> allMusics;

    public MusicStoreRepository(Application application){
        MusicStoreDataBase musicStoreDataBase = MusicStoreDataBase.getInstance(application);
        musicStoreDao = musicStoreDataBase.musicStoreDao();
        allMusics = musicStoreDao.getAllMusics();
    }

    public void insert(MusicStore musicStore){
        new InsertMusicAsynTask(musicStoreDao).execute(musicStore);
    }

    public void update(MusicStore musicStore){
        new UpdateMusicAsynTask(musicStoreDao).execute(musicStore);
    }

    public void delete(MusicStore musicStore){
        new DeleteMusicAsynTask(musicStoreDao).execute(musicStore);
    }

    public LiveData<List<MusicStore>> getAllMusics(){
        return allMusics;
    }

    private static class InsertMusicAsynTask extends AsyncTask<MusicStore, Void, Void>{
        private MusicStoreDao musicStoreDao;
        private InsertMusicAsynTask(MusicStoreDao musicStoreDao){
            this.musicStoreDao = musicStoreDao;
        }

        @Override
        protected Void doInBackground(MusicStore... musicStores) {
            musicStoreDao.insert(musicStores[0]);
            return null;
        }
    }

    private static class DeleteMusicAsynTask extends AsyncTask<MusicStore, Void, Void>{
        private MusicStoreDao musicStoreDao;
        private DeleteMusicAsynTask(MusicStoreDao musicStoreDao){
            this.musicStoreDao = musicStoreDao;
        }

        @Override
        protected Void doInBackground(MusicStore... musicStores) {

            return null;
        }
    }

    private static class UpdateMusicAsynTask extends AsyncTask<MusicStore, Void, Void>{
        private MusicStoreDao musicStoreDao;
        private UpdateMusicAsynTask(MusicStoreDao musicStoreDao){
            this.musicStoreDao = musicStoreDao;
        }

        @Override
        protected Void doInBackground(MusicStore... musicStores) {
            return null;
        }
    }
}
