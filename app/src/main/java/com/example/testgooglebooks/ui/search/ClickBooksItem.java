package com.example.testgooglebooks.ui.search;

import com.example.testgooglebooks.models.AdapterModel;

public interface ClickBooksItem {
    abstract void clickFavImage(AdapterModel model);

    abstract void clickItem(String url);
}
