package com.kalelman.moviesfeed.movies;


import io.reactivex.Observable;

public interface MoviesMVP {

    interface View {
        // Modelo de datos
        void updateData(ViewModel viewModel);
        // mostrar mensajes al usuario
        void showSnackBar(String s);

    }

    interface Presenter {

        // cargar datos desde el modelo
        void loadData();

        // desuscribirse de Reactive Data
        void rxJavaUnsuscribe();
        // configurar una vista
        void setView(MoviesMVP.View view);

    }

    interface Model {
        Observable<ViewModel> result();

    }

}
