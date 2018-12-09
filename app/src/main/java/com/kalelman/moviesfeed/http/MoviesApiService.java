package com.kalelman.moviesfeed.http;

import com.kalelman.moviesfeed.http.apimodel.TopMoviesRated;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {
    /*@GET("top_rated")
    Observable<TopMoviesRated> getTopMoviesRated(@Query("api_key") String api_key,
                                                 @Query("page") Integer page);*/
    //forma de hacerlo con la url ofuscada
    @GET("top_rated")
    Observable<TopMoviesRated> getTopMoviesRated(@Query("page") Integer page);
}
