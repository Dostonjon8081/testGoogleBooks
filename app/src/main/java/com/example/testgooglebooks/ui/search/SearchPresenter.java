package com.example.testgooglebooks.ui.search;

import android.util.Log;

import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDBEntity;
import com.example.testgooglebooks.models.BookDto;
import com.example.testgooglebooks.service.neetwork.ApiClient;

import java.util.concurrent.Executors;


public class SearchPresenter implements SearchContract.Presenter {

    private final PresenterService presenterService;
    private final SearchContract.View view;


    public SearchPresenter(
            SearchContract.View view) {
        this.view = view;
        presenterService = new PresenterService(ApiClient.getClient());
    }

    @Override
    public void start() {

    }

    @Override
    public void search(String text) {
        view.showBookLoading();

        presenterService.searchBooks(text, new PresenterService.SearchBookCallback() {
            @Override
            public void onSuccess(BookDto bookDto) {
                view.showBookSuccess(DtoMapper.mapModel(bookDto,presenterService));
                cancel();
            }

            @Override
            public void onError(String networkError) {
                view.showBookError();
                cancel();
            }
        });
    }

    @Override
    public void insertBook(AdapterModel model) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                BookDBEntity bookDBEntity;
                bookDBEntity = new BookDBEntity(model.getName(), model.getImage(), model.getAuthors().toString(), true);
                presenterService.insertFavBookEntity(bookDBEntity);
            }
        });

    }

    @Override
    public void getAllBookFromDb() {

    }

    @Override
    public void cancel() {
        view.hideLoading();
    }

    @Override
    public void deleteOneBook(AdapterModel model) {

    }


}
