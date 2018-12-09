package com.kalelman.moviesfeed.movies;



import io.reactivex.Observable;

public interface MoviesRepository {

    Observable<Result> getResultData();
    Observable<String> getCountryData();

}
