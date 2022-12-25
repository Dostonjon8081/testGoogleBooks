package com.example.testgooglebooks.models;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.testgooglebooks.service.db.FavBookDao;

import java.util.ArrayList;

@Entity(tableName = FavBookDao.TABLE_NAME)
public class BookDBEntity {
        public BookDBEntity(String name, String image,String author, boolean isFav) {
                this.name = name;
                this.image = image;
                this.author = author;
                this.isFav = isFav;
        }

        @PrimaryKey(autoGenerate = true)
        private int id;
        private String name;
        private String image;
        private String author ="";
        private boolean isFav = true;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public boolean isFav() {
                return isFav;
        }

        public void setFav(boolean fav) {
                isFav = fav;
        }
}
