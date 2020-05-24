package com.example.musicapp.views;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicapp.R;
import com.example.musicapp.databinding.FragmentMyMusicBinding;

public class MyMusicFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    private RecyclerView recyclerView;
    public MyMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentMyMusicBinding fragmentMyMusicBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_music, null, false);
        View view = fragmentMyMusicBinding.getRoot();
        recyclerView = view.findViewById(R.id.myMusicRecyclerId);
        return view;
        //return inflater.inflate(R.layout.fragment_my_music, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
