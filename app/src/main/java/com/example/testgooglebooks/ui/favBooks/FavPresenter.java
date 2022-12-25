package com.example.testgooglebooks.ui.favBooks;

import android.util.Log;

import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDBEntity;
import com.example.testgooglebooks.ui.search.DtoMapper;
import com.example.testgooglebooks.ui.search.SearchContract;

import java.util.List;


public class FavPresenter implements SearchContract.Presenter {

    private final FavPresenterService presenterService;
    private final SearchContract.View view;


    public FavPresenter(
            SearchContract.View view) {
        this.view = view;
        presenterService = new FavPresenterService();
    }

    @Override
    public void start() {

    }

    @Override
    public void search(String text) {

    }

    @Override
    public void insertBook(AdapterModel model) {
        BookDBEntity bookDBEntity;
        bookDBEntity = new BookDBEntity(model.getName(), model.getImage(), model.getAuthors().toString(), true);
    }

    @Override
    public void getAllBookFromDb() {
        view.showBookLoading();

        Log.d(DtoMapper.TAG, "getAllBookFromDb: ");
        presenterService.getAllBooksFromDB(new FavPresenterService.SearchFavBookCallback() {
            @Override
            public void onSuccess(List<AdapterModel> models) {
                view.showBookSuccess(models);
                view.hideLoading();
            }

            @Override
            public void onError(String networkError) {
                view.hideLoading();
            }
        });
    }

    @Override
    public void cancel() {
        view.hideLoading();
    }

    @Override
    public void deleteOneBook(AdapterModel model) {
        presenterService.deleteOneBook(model);
    }


}
