package com.example.musicapp.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.musicapp.views.FavouriteFragment;
import com.example.musicapp.views.HomeFragment;
import com.example.musicapp.views.MyMusicFragment;
import com.example.musicapp.views.OnlineFragment;
import com.example.musicapp.R;
import com.example.musicapp.views.SearchFragment;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class BottomViewModel {

    SpaceNavigationView spaceNavigationView;
    private Context context;
    private Fragment fragment;
    private FragmentTransaction fragmentTransaction;
    private   FragmentManager fragmentManager;
    public BottomViewModel(SpaceNavigationView spaceNavigationView, Context context,  FragmentManager fragmentManager, FragmentTransaction fragmentTransaction) {
        this.spaceNavigationView = spaceNavigationView;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.fragmentTransaction = fragmentTransaction;
    }

    public SpaceNavigationView getSpaceNavigationView() {
        return spaceNavigationView;
    }

    public void setSpaceNavigationView(SpaceNavigationView spaceNavigationView) {
        this.spaceNavigationView = spaceNavigationView;
    }

    public void fragmentChanger(String title, Object expectedFragment){
        // mToolBarTextView.setText(title);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, (Fragment) expectedFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
    public void SetNavigation (SpaceNavigationView spaceNavigationView) {
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_home_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_search_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_music_note_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_favorite_border_black_24dp));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(context, "onCentreButtonClick", Toast.LENGTH_SHORT).show();
                fragmentChanger("", new MyMusicFragment());

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(context, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                int itemNum = itemIndex;
                switch (itemIndex){
                    case 0:fragmentChanger("", new HomeFragment());
                        break;
                    case 1: fragmentChanger("", new SearchFragment());
                        break;
                    case 2: fragmentChanger("", new OnlineFragment());
                        break;
                    case 3: fragmentChanger("", new FavouriteFragment());
                        break;

                }

                
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(context, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
