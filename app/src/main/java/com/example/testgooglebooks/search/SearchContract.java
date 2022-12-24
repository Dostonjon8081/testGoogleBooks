package com.example.testgooglebooks.search;

import com.example.testgooglebooks.base.BasePresenter;
import com.example.testgooglebooks.base.BaseView;
import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDto;

import java.util.List;

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void showBookError();

        void showBookSuccess(List<AdapterModel> models);

        void showBookLoading();

        void hideLoading();
    }

    interface Presenter extends BasePresenter {

        void search(String text);

        void cancel();

    }

}
