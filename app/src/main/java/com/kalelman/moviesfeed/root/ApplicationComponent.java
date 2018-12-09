package com.kalelman.moviesfeed.root;

import com.kalelman.moviesfeed.MainActivity;
import com.kalelman.moviesfeed.http.MovieExtraInfoApiModule;
import com.kalelman.moviesfeed.http.MovieTitleApiModule;
import com.kalelman.moviesfeed.movies.MoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,
        MoviesModule.class,
        MovieTitleApiModule.class,
        MovieExtraInfoApiModule.class})

public interface ApplicationComponent {

    void inject(MainActivity target);

}
