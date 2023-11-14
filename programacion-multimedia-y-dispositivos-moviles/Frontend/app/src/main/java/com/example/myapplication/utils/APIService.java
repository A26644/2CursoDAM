package com.example.myapplication.utils;

import com.example.myapplication.login.data.MyData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("Controller")
    Call<MyData> getDataUsers(@Query("ACTION") String action);

    @GET("Controller")
    Call<MyData> getDataMovies(@Query("ACTION") String action);

}
