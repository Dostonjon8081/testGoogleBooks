package com.example.testgooglebooks.ui.favBooks;

import static dagger.internal.Preconditions.checkNotNull;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testgooglebooks.R;
import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDto;
import com.example.testgooglebooks.ui.search.ClickBooksItem;
import com.example.testgooglebooks.ui.search.SearchContract;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FavBooksFragment extends Fragment implements SearchContract.View, ClickBooksItem {
    private BookDto bookDto;
    private SearchContract.Presenter presenter;

    private RecyclerView rv;
    private ProgressBar pb;
    private RvFavBookAdapter adapter;

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
        presenter = new FavPresenter(this);

        rv = requireActivity().findViewById(R.id.fav_book_rv);
        pb = requireActivity().findViewById(R.id.progressbar_fav_book);
        adapter = new RvFavBookAdapter(this);
        rv.setAdapter(adapter);

        loadBooksFromDB();
    }

    private void loadBooksFromDB() {
        presenter.getAllBookFromDb();
    }

    @Override
    public void setPresenter(@NotNull SearchContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    @Override
    public void showBookError() {
        hideLoading();
    }

    @Override
    public void showBookSuccess(List<AdapterModel> models) {
        adapter.initList(models);
        hideLoading();
    }

    @Override
    public void showBookLoading() {
        pb.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void clickFavImage(AdapterModel model) {
        presenter.deleteOneBook(model);
    }

    @Override
    public void clickItem(String url) {

    }
}
