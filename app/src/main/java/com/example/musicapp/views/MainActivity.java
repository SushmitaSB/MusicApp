package com.example.musicapp.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.musicapp.R;
import com.example.musicapp.databinding.ActivityMainBinding;
import com.example.musicapp.model.GetMusicFromStorage;
import com.example.musicapp.viewmodel.BottomViewModel;
import com.example.musicapp.viewmodel.MusicStoreViewModel;
import com.luseen.spacenavigation.SpaceNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final int MY_PERMISSION_REQUEST = 1;
    private ActivityMainBinding activityMainBinding;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    SpaceNavigationView spaceNavigationView;
    MusicStoreViewModel musicStoreViewModel;
    GetMusicFromStorage getMusicFromStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        //musicStoreViewModel = ViewModelProviders.of(this).get(MusicStoreViewModel.class);
        try {

            musicStoreViewModel =  new ViewModelProvider(this).get(MusicStoreViewModel.class);

        }catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.getMessage();
            ex.getStackTrace();
        }

        getMusicFromStorage = new GetMusicFromStorage(MainActivity.this, musicStoreViewModel);
        fragment = new Fragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BottomViewModel bottomViewModel = new BottomViewModel(spaceNavigationView, MainActivity.this,fragmentManager, fragmentTransaction);
        bottomViewModel.SetNavigation(spaceNavigationView);
        bottomViewModel.fragmentChanger("", new HomeFragment());
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            }
        }else {
            getMusicFromStorage.GetMusic();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case MY_PERMISSION_REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();

                        getMusicFromStorage.GetMusic();

                    }else {
                        Toast.makeText(this, "No Permission Granted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    return;
                }
            }
        }
    }
}
