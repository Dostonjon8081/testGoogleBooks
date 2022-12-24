package com.example.testgooglebooks.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testgooglebooks.ApiClient;
import com.example.testgooglebooks.App;
import com.example.testgooglebooks.BookNetworkService;
import com.example.testgooglebooks.R;
import com.example.testgooglebooks.models.BookDto;

public class FavBooksFragment extends Fragment {
    private BookDto bookDto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fav_books, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("MyBook", "onCreatedView");

    }
}
