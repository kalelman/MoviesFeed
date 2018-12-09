package com.kalelman.moviesfeed.movies;



import com.kalelman.moviesfeed.http.apimodel.Result;

import io.reactivex.Observable;

public interface Repository {

    Observable<Result> getResultData();
    Observable<String> getCountryData();

}
