package com.example.myapplication.topRated.Model;

import com.example.myapplication.top.data.TopData;
import com.example.myapplication.topRated.Data.TopRatedData;
import com.example.myapplication.topRated.Presenter.TopRatedPresenter;
import com.example.myapplication.topRated.TopRatedContract;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedModel implements TopRatedContract.Model {
    TopRatedPresenter topRatedPresenter;
    public TopRatedModel(TopRatedPresenter topRatedPresenter) {
        this.topRatedPresenter = topRatedPresenter;
    }

    @Override
    public void TopRatedAPI() {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<ArrayList<TopRatedData>> call = apiService.GetMostRatedUsers("USUARIO.FINDMOSTSTAR");
        call.enqueue(new Callback<ArrayList<TopRatedData>>() {
            @Override
            public void onResponse(Call<ArrayList<TopRatedData>> call, Response<ArrayList<TopRatedData>> response) {
                if (response.isSuccessful()){
                    System.out.println(response.body().toString());
                    topRatedPresenter.TopRatedOnSuccess(response.body());
                }else{
                    topRatedPresenter.TopRatedOnFailure("Error al cargar los usuarios mas valorados");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<TopRatedData>> call, Throwable t) {
                topRatedPresenter.TopRatedOnFailure("Error al cargar los usuarios mas valorados");

            }
        });
    }
}
