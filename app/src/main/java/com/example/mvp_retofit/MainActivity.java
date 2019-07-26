package com.example.mvp_retofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvp_retofit.Adapter.MainRVAdapter;
import com.example.mvp_retofit.Model.ResultsItem;
import com.example.mvp_retofit.Presenter.MainPresenter;
import com.example.mvp_retofit.Presenter.MainPresenterImpl;
import com.example.mvp_retofit.View.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    RecyclerView recyclerView;
    MainRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.getListPeople();
    }

    @Override
    public void peopleData(List<ResultsItem> people) {
        for (ResultsItem resultsItem: people){
            recyclerView = findViewById(R.id.main_RV);
            recyclerView.setHasFixedSize(true);
            adapter = new MainRVAdapter(people , this);
            adapter.setContext(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(adapter);
        }
    }
}
