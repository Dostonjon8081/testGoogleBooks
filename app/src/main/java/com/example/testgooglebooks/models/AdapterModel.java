package com.example.testgooglebooks.models;

import java.util.ArrayList;
import java.util.List;

public class AdapterModel {

    private String image;
    private String name;
    private ArrayList<String> authors = new ArrayList<>();
    private boolean isFav = false;


    public AdapterModel(String image, String name, List<String> authors) {
        this.image = image;
        this.name = name;
        this.authors.addAll(authors);
    }

    public AdapterModel(String image, String name, List<String> authors, boolean isFav) {
        this.image = image;
        this.name = name;
        this.authors.addAll(authors);
        this.isFav = isFav;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }


    @Override
    public String toString() {
        return "AdapterModel{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", author='" + authors + '\'' +
                ", isFav=" + isFav +
                '}';
    }
}
