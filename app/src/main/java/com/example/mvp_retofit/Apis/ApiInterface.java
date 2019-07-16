package com.example.mvp_retofit.Apis;

import com.example.mvp_retofit.Model.PeopleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("people")
    Call<PeopleResponse> getPeople();
}
