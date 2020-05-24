package com.example.musicapp.roompojo;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {MusicStore.class}, version = 1)
public abstract class MusicStoreDataBase extends RoomDatabase {
    private static MusicStoreDataBase instance;

    public abstract  MusicStoreDao musicStoreDao();

    public static synchronized MusicStoreDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MusicStoreDataBase.class, "music_store")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private  static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsynTask(instance).execute();
        }
    };

    private static class PopulateDbAsynTask extends AsyncTask<Void, Void, Void>{
        private  MusicStoreDao musicStoreDao;

        private PopulateDbAsynTask(MusicStoreDataBase dataBase){
            musicStoreDao = dataBase.musicStoreDao();


        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
