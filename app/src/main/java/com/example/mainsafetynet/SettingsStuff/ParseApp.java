package com.example.mainsafetynet.SettingsStuff;

import android.app.Application;

import com.example.mainsafetynet.BuildConfig;
import com.parse.Parse;

public class ParseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(BuildConfig.PARSEKEY)
                .clientKey(BuildConfig.PARSECLIENT)
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
