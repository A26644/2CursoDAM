package com.example.myapplication.utils;

import com.example.myapplication.beans.Usuario;
import com.example.myapplication.login.data.MyLoginData;

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
    Call<MyLoginData> getDataUsers(@Query("ACTION") String action);

    @GET("Controller")
    Call<MyLoginData> getDataMovies(@Query("ACTION") String action);
    @GET("Controller")
    Call<MyLoginData> getLogin(@Query("ACTION") String action, @Query("EMAIL") String nombre, @Query("PASS") String pass);

}
