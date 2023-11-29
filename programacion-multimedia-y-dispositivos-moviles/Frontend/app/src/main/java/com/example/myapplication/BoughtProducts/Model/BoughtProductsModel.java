package com.example.myapplication.BoughtProducts.Model;

import com.example.myapplication.BoughtProducts.Adapter.BoughtProductsAdapter;
import com.example.myapplication.BoughtProducts.BoughtProductsContract;
import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.BoughtProducts.Presenter.BoughtProductsPresenter;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoughtProductsModel implements BoughtProductsContract.Model {
    BoughtProductsPresenter presenter;

    public BoughtProductsModel(BoughtProductsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void MyBoughtProductsAPI(Integer userId) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<ArrayList<BoughtProductsData>> call = apiService.getMyBoughtProducts("VENTA.FIND", userId);
        call.enqueue(new Callback<ArrayList<BoughtProductsData>>() {
            @Override
            public void onResponse(Call<ArrayList<BoughtProductsData>> call, Response<ArrayList<BoughtProductsData>> response) {
                if (response.isSuccessful()) {
                    for (BoughtProductsData data: response.body()) {
                        System.out.println(data.toString());
                    }
                    presenter.SuccessMyBoughtProducts(response.body());
                } else {
                    presenter.FailureMyBoughtProducts("Error al cargar los productos que has comprado");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<BoughtProductsData>> call, Throwable t) {
                presenter.FailureMyBoughtProducts("Error al cargar los productos que has comprado");
            }
        });
    }
}
