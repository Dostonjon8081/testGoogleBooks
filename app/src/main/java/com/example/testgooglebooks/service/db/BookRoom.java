package com.example.testgooglebooks.service.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testgooglebooks.models.BookDBEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {BookDBEntity.class}, version = 1, exportSchema = false)
public abstract class BookRoom extends RoomDatabase {

    public abstract FavBookDao dao();

    public static volatile FavBookDao INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static FavBookDao getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BookRoom.class, "MyBook")
                            .build().dao();
                }
            }
        }
        return INSTANCE;
    }
}
