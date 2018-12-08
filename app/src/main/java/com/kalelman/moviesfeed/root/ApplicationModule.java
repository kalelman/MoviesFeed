package com.kalelman.moviesfeed.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//suministra la applicacion y el contexto

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application app) {
        this.application = app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
