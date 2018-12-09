package com.kalelman.moviesfeed.root;

import com.kalelman.moviesfeed.MainActivity;
import com.kalelman.moviesfeed.http.MovieTitleApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, MovieTitleApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);




}
