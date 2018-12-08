package com.kalelman.moviesfeed.root;

import android.app.Application;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        // generando el Application Component
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    // Devolviendo nuestro Application Component
    public ApplicationComponent getComponent() {
        return component;
    }
}
