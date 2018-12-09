package com.kalelman.moviesfeed.movies;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class MoviesModel implements MoviesMVP.Model {

    private MoviesRepository repository;

    public MoviesModel(MoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(repository.getResultData(), repository.getCountryData(), new BiFunction<Result, String, ViewModel>() {
            @Override
            public ViewModel apply(Result result, String country) {
                //TODO: cambiar result to String cuando tengamos el POJO de datos
                return new ViewModel(result.toString(), country);
            }
        });
    }
}
