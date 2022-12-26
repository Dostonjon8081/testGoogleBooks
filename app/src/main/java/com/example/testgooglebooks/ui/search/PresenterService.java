package com.example.testgooglebooks.ui.search;

import android.util.Log;

import com.example.testgooglebooks.models.BookDBEntity;
import com.example.testgooglebooks.service.db.BookRoom;
import com.example.testgooglebooks.service.db.FavBookDao;
import com.example.testgooglebooks.service.neetwork.BookNetworkService;
import com.example.testgooglebooks.models.BookDto;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class PresenterService {

    private BookNetworkService networkService;
    private FavBookDao dao;

    public PresenterService(BookNetworkService networkService) {
        this.networkService = networkService;
        this.dao = BookRoom.INSTANCE;
    }

    public void searchBooks(String text, SearchBookCallback callback) {

        networkService.searchBooks(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookDto>() {


                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BookDto bookDto) {
                        callback.onSuccess(bookDto);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void insertFavBookEntity(BookDBEntity entity){
        dao.insert(entity);
    }

    public BookDBEntity getBook(String name){
        return dao.getOneBook(name);
    }

    public boolean isExistsBook(String bookName){
        return dao.isExistsBook(bookName);
    }

    public interface SearchBookCallback {
        void onSuccess(BookDto bookDto);

        void onError(String networkError);


    }
}
