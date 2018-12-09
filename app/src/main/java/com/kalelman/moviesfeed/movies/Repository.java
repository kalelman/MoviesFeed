package com.kalelman.moviesfeed.movies;



import com.kalelman.moviesfeed.http.apimodel.Result;

import io.reactivex.Observable;

public interface Repository {
    // Result
    Observable<Result> getResultFromNetwork();
    Observable<Result> getResultFromCache();
    Observable<Result> getResultData();
    // Country
    Observable<String> getCountryFromNetwork();
    Observable<String> getCountryFromCache();
    Observable<String> getCountryData();
}
