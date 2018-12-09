package com.kalelman.moviesfeed.movies;



import com.kalelman.moviesfeed.http.apimodel.Result;

import io.reactivex.Observable;

public interface MoviesRepository {

    Observable<Result> getResultData();
    Observable<String> getCountryData();

}
