package com.example.mainsafetynet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mainsafetynet.fragments.MapsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Assigning Values
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Fragment Navigation
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.Home:
                default:
                    fragment = new MapsFragment();
                    break;
            }

            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
            return true;
        });

    }





}