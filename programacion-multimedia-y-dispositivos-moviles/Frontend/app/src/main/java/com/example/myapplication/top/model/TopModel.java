package com.example.myapplication.top.model;

import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.top.ContractTop;
import com.example.myapplication.top.data.TopData;
import com.example.myapplication.top.presenter.TopPresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopModel implements ContractTop.Model{
    private TopPresenter topPresenter;
    public TopModel(TopPresenter topPresenter){
        this.topPresenter = topPresenter;
    }
    @Override
    public void topAPI(topListener topListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<ArrayList<TopData>> call = apiService.getMostUsers("USUARIO.FINDMOST");
        call.enqueue(new Callback<ArrayList<TopData>>() {
            @Override
            public void onResponse(Call<ArrayList<TopData>> call, Response<ArrayList<TopData>> response) {
                if (response.isSuccessful()){
                    System.out.println(response.body());
                    topListener.successTop(response.body());
                }else{
                    topListener.failureTop("Error al cargar los usuarios mas valorados");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<TopData>> call, Throwable t) {
                topListener.failureTop("Error al cargar los usuarios mas valorados" + t.getMessage());

            }
        });

    }
}
