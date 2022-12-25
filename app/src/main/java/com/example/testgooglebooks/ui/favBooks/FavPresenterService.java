package com.example.testgooglebooks.ui.favBooks;

import android.util.Log;

import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDBEntity;
import com.example.testgooglebooks.service.db.BookRoom;
import com.example.testgooglebooks.service.db.FavBookDao;
import com.example.testgooglebooks.ui.search.DtoMapper;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class FavPresenterService {

    private FavBookDao dao;

    public FavPresenterService() {
        this.dao = BookRoom.INSTANCE;
    }


    public BookDBEntity getBook(String name) {
        return dao.getOneBook(name);
    }

    public void getAllBooksFromDB(SearchFavBookCallback callback) {
        dao.bookList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BookDBEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<BookDBEntity> bookDBEntities) {
                        callback.onSuccess(Mapper.mapperFromEntityToModel(bookDBEntities));
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

    public void deleteOneBook(AdapterModel model) {
       Executors.newSingleThreadExecutor().execute(new Runnable() {
           @Override
           public void run() {
               dao.deleteOneBook(model.getName());
           }
       });
    }


    public interface SearchFavBookCallback {
        void onSuccess(List<AdapterModel> models);

        void onError(String networkError);


    }
}
