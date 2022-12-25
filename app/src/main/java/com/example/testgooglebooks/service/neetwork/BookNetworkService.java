package com.example.testgooglebooks.service.neetwork;


import com.example.testgooglebooks.models.BookDto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookNetworkService {

    @GET("https://www.googleapis.com/books/v1/volumes")
    Observable<BookDto> searchBooks(@Query("q") String q);
}
