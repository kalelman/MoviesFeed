package com.kalelman.moviesfeed.movies;

import com.kalelman.moviesfeed.http.MoviesApiService;
import com.kalelman.moviesfeed.http.MoviesExtraInfoApisService;
import com.kalelman.moviesfeed.http.apimodel.Result;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MoviesRepository implements Repository {

    private MoviesApiService moviesApiService;
    private MoviesExtraInfoApisService moviesExtraInfoApisService;

    private List<String> countries;
    private List<Result> results;
    private long lastTimestamp;

    private static long CACHE_LIFETIME = 20 * 1000; //Cache que dura 20 segundos


    public MoviesRepository(MoviesApiService mService, MoviesExtraInfoApisService eService) {
        this.moviesApiService = mService;
        this.moviesExtraInfoApisService = eService;

        this.lastTimestamp = System.currentTimeMillis();

        this.countries = new ArrayList<>();
        this.results = new ArrayList<>();
    }
    // saber si la cache esta actualizada
    // SI la diferencia entre System.currentTimeMillis() - lastTimestamp es menor que CACHE_LIFETIME
    // esta actualizada la cache
    public boolean isUpdated() {
        return (System.currentTimeMillis() - lastTimestamp) < CACHE_LIFETIME;
    }

    @Override
    public Observable<Result> getResultFromNetwork() {
        return null;
    }

    @Override
    public Observable<Result> getResultFromCache() {
        if (isUpdated()) {
            return Observable.fromIterable(results);
        } else {
            lastTimestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultData() {
        return null;
    }

    @Override
    public Observable<String> getCountryFromNetwork() {
        return null;
    }

    @Override
    public Observable<String> getCountryFromCache() {
        if (isUpdated()) {
            return Observable.fromIterable(countries);
        } else {
            lastTimestamp = System.currentTimeMillis();
            results.clear();
            return  Observable.empty();
        }
    }

    @Override
    public Observable<String> getCountryData() {
        return null;
    }
}
