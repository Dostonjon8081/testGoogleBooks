package com.example.testgooglebooks.search;

import android.util.Log;

import com.example.testgooglebooks.ApiClient;
import com.example.testgooglebooks.models.BookDto;

import javax.inject.Inject;


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
                view.showBookSuccess(DtoMapper.mapModel(bookDto));
//                DtoMapper.mapModel(bookDto);
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
    public void cancel() {
        view.hideLoading();
    }

}
