package com.example.travel_buddy.login;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication instance;
    private static PrefHelper prefHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        prefHelper = PrefHelper.getInstance(this);
    }

    public MainApplication getInstance(){
        return instance;
    }

    public static PrefHelper getPrefHelper(){
        return prefHelper;
    }
}
