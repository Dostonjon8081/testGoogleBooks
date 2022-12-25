package com.example.testgooglebooks;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.testgooglebooks.ui.search.SearchBooksFragment;
import com.example.testgooglebooks.ui.favBooks.FavBooksFragment;
import com.google.android.material.tabs.TabLayout;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm = getSupportFragmentManager();
    private FrameLayout container;
    private TabLayout tabLayout;

    static String TAG = "MyBook";;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.fragment_container);
        replaceFragment(new WeakReference<>(new SearchBooksFragment()));

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        replaceFragment(new WeakReference<>(new SearchBooksFragment())); break;
                    case 1:
                        replaceFragment(new WeakReference<>(new FavBooksFragment()));break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void replaceFragment(WeakReference<Fragment> fragmentWeakReference) {
//        if (ft.isEmpty()) ft.add(R.id.fragment_container, fragmentWeakReference.get());
//        else ft.replace(R.id.fragment_container, fragmentWeakReference.get());
        FragmentTransaction ft = fm.beginTransaction();
        Log.d(TAG, "replaceFragment: " +fragmentWeakReference.get().toString());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.fragment_container, fragmentWeakReference.get());
        ft.commit();
    }
}
