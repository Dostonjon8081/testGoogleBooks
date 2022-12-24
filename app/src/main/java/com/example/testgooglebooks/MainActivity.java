package com.example.testgooglebooks;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.testgooglebooks.search.SearchBooksFragment;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.fragment_container);
        replaceFragment(new WeakReference<>(new SearchBooksFragment()));

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void replaceFragment(WeakReference<Fragment> fragmentWeakReference) {
        if (ft.isEmpty()) ft.add(R.id.fragment_container, fragmentWeakReference.get()).commit();
        else ft.replace(R.id.fragment_container, fragmentWeakReference.get()).commit();
    }
}
