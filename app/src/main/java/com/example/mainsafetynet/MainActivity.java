package com.example.mainsafetynet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mainsafetynet.fragments.MapsFragment;
import com.example.mainsafetynet.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment Map;
    Fragment Setting;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        Map = new MapsFragment();
        Setting = new SettingsFragment();

        fragmentManager.beginTransaction()
                .add(R.id.flContainer,Setting)
                .add(R.id.flContainer,Map)
                .commit();
        //Fragment Navigation
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.Home:
                default:
                    fragmentManager.beginTransaction()
                            .show(Map)
                            .hide(Setting)
                            .commit();
                    break;
                case R.id.Settings:
                    fragmentManager.beginTransaction()
                            .show(Setting)
                            .hide(Map)
                            .commit();
                    break;
            }


            return true;
        });

    }





}