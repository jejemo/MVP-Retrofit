package com.example.mvp_retofit.Apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUrl {
    private Retrofit retrofit = null;
    private String BASE_URL = "https://private-0e6b9-ganjarwidiatmansyah.apiary-mock.com/";

    public ApiInterface getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
