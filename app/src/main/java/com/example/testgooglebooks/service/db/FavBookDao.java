package com.example.testgooglebooks.service.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.testgooglebooks.models.BookDBEntity;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface FavBookDao {

    public static String TABLE_NAME="MyBook";

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(BookDBEntity... entity);

    @Delete
    void delete(BookDBEntity... entity);

    @Query("DELETE FROM MyBook where name=:name")
    int deleteOneBook(String name);

    @Query("SELECT * FROM MyBook")
    Observable<List<BookDBEntity>> bookList();

    @Query("SELECT * FROM MYBOOK WHERE name=:bookName")
    BookDBEntity getOneBook(String bookName);

    @Query("SELECT 1 FROM MyBook WHERE name=:bookName")
    boolean isExistsBook(String bookName);
}
