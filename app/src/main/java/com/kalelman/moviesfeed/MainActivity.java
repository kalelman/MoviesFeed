package com.kalelman.moviesfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kalelman.moviesfeed.movies.ListAdapter;
import com.kalelman.moviesfeed.movies.MoviesMVP;
import com.kalelman.moviesfeed.movies.ViewModel;
import com.kalelman.moviesfeed.root.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MoviesMVP.View {

    private final String TAG = MainActivity.class.getName();

    @BindView(R.id.activity_root_view)
    ViewGroup rootView;
    @BindView(R.id.recycler_view_movies)
    RecyclerView recyclerView;

    @Inject
    MoviesMVP.Presenter presenter;

    private ListAdapter listAdapter;
    private List<ViewModel> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App) getApplication()).getComponent().inject(this);

        listAdapter = new ListAdapter(resultList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    public void updateData(ViewModel viewModel) {

    }

    @Override
    public void showSnackBar(String s) {

    }
}
