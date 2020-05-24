package com.example.musicapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.musicapp.R;
import com.example.musicapp.databinding.ActivitySplashScreenBinding;
import com.example.musicapp.viewmodel.SplashViewModel;

public class SplashScreen extends AppCompatActivity {
    private TextView tvName;
    Handler handler;
    private ActivitySplashScreenBinding activitySplashScreenBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash_screen);

        activitySplashScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);
        SplashViewModel splashViewModel = new SplashViewModel("Music makes everything better");
        activitySplashScreenBinding.setSplash(splashViewModel);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent newIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(newIntent);
            }
        },3000);

        tvName = findViewById(R.id.nameId);
         Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
         a.reset();
         tvName.clearAnimation();
         tvName.startAnimation(a);

    }
}
