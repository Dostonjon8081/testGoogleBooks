package com.example.testgooglebooks;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static BookNetworkService INSTANCE = null;
    public static final String BASE_URL = "https://www.googleapis.com/books/v1/volume/";
    private static Retrofit retrofit = null;

    public static BookNetworkService getClient() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(BookNetworkService.class);
        }
        return INSTANCE;
    }
}
