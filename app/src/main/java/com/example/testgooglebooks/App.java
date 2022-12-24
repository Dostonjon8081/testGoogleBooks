package com.example.testgooglebooks;

import android.app.Application;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiClient.getClient();

//        ApplicationComponent appComponent = DaggerApplicationComponent.create();
    }
}
