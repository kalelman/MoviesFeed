package com.kalelman.moviesfeed.root;

import android.app.Application;

import com.kalelman.moviesfeed.http.MovieExtraInfoApiModule;
import com.kalelman.moviesfeed.http.MovieTitleApiModule;
import com.kalelman.moviesfeed.movies.MoviesModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        // generando el Application Component
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .moviesModule(new MoviesModule())
                .movieTitleApiModule(new MovieTitleApiModule())
                .movieExtraInfoApiModule(new MovieExtraInfoApiModule())
                .build();
    }
    // Devolviendo nuestro Application Component
    public ApplicationComponent getComponent() {
        return component;
    }
}
