package com.example.musicapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.musicapp.roompojo.MusicStore;
import com.example.musicapp.roompojo.MusicStoreRepository;

import java.util.List;

public class MusicStoreViewModel extends AndroidViewModel {
    private MusicStoreRepository musicStoreRepository;
    private LiveData<List<MusicStore>> allMusics;
    public MusicStoreViewModel(Application application) {
        super(application);
        musicStoreRepository = new MusicStoreRepository(application);
       // allMusics = musicStoreRepository.getAllMusics();
    }

    public void insert(MusicStore musicStore){
        musicStoreRepository.insert(musicStore);
    }

    public void update(MusicStore musicStore){
        musicStoreRepository.update(musicStore);
    }
    public LiveData<List<MusicStore>> getAllMusics(){
        return allMusics;
    }
}
