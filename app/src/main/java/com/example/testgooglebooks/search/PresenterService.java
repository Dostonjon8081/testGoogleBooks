package com.example.testgooglebooks.search;

import com.example.testgooglebooks.BookNetworkService;
import com.example.testgooglebooks.models.BookDto;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class PresenterService {
    private final BookNetworkService networkService;
    CompositeDisposable disposable = new CompositeDisposable();

    public PresenterService(BookNetworkService networkService) {
        this.networkService = networkService;
    }

    public void searchBooks(String text, SearchBookCallback callback) {

        networkService.searchBooks(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookDto>() {


                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(BookDto bookDto) {
                        callback.onSuccess(bookDto);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                        cancel();
                    }

                    @Override
                    public void onComplete() {
                        cancel();
                    }
                });
    }

    public void cancel() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public interface SearchBookCallback {
        void onSuccess(BookDto bookDto);

        void onError(String networkError);


    }
}
