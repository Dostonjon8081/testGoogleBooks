package com.example.testgooglebooks;

import android.app.Application;

import com.example.testgooglebooks.service.db.BookRoom;
import com.example.testgooglebooks.service.neetwork.ApiClient;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiClient.getClient();
        BookRoom.getDatabase(this);

//        ApplicationComponent appComponent = DaggerApplicationComponent.create();
    }
}
