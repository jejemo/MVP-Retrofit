package com.example.mvp_retofit.Presenter;

import com.example.mvp_retofit.Apis.ApiUrl;
import com.example.mvp_retofit.Model.PeopleResponse;
import com.example.mvp_retofit.Model.ResultsItem;
import com.example.mvp_retofit.View.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter {
    MainView mainView;
    ApiUrl apiUrl;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        if (apiUrl == null){
            this.apiUrl = new ApiUrl();
        }
    }

    @Override
    public void getListPeople() {
        apiUrl
                .getAPI()
                .getPeople()
                .enqueue(new Callback<PeopleResponse>() {
                    @Override
                    public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                        List<ResultsItem> peopleData = response.body().getResults();
                        mainView.peopleData(peopleData);
                    }

                    @Override
                    public void onFailure(Call<PeopleResponse> call, Throwable t) {

                    }
                });
    }
}
