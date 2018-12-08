package com.kalelman.moviesfeed.root;

import com.kalelman.moviesfeed.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);




}
