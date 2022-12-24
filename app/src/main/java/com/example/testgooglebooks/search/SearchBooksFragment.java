package com.example.testgooglebooks.search;

import static com.google.common.base.Preconditions.checkNotNull;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testgooglebooks.ApiClient;
import com.example.testgooglebooks.BookNetworkService;
import com.example.testgooglebooks.R;
import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class SearchBooksFragment extends Fragment implements SearchContract.View {


    private static String TAG = "MyBook";

    private BookDto bookDto;
    private BookNetworkService networkService;
    private Disposable disposable = new CompositeDisposable();

    private SearchContract.Presenter presenter;
    private PresenterService presenterService;
    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private RecyclerView rv;

    private RvBookAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        networkService = ApiClient.getClient();
        return inflater.inflate(R.layout.fragment_search_books, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenterService = new PresenterService(ApiClient.getClient());
        presenter = new SearchPresenter(this);
        fab = requireActivity().findViewById(R.id.fab);
        progressBar = requireActivity().findViewById(R.id.progressbar_book);
        rv = requireActivity().findViewById(R.id.book_rv);




        fab.setOnClickListener(view1 -> {
            presenter.search("stive");
        });
    }

    @Override
    public void setPresenter(@NotNull SearchContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    @Override
    public void showBookError() {

    }

    @Override
    public void showBookSuccess(List<AdapterModel> models) {

        Log.d(TAG, "onSuccess: " + models);

        adapter = new RvBookAdapter(models);
        rv.setAdapter(adapter);
    }

    @Override
    public void showBookLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onDetach() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
        super.onDetach();
    }


}
