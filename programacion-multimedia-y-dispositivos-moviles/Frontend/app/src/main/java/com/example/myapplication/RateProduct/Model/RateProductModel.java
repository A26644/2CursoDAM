package com.example.myapplication.RateProduct.Model;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.RateProduct.Data.RateInData;
import com.example.myapplication.RateProduct.Data.RateProductData;
import com.example.myapplication.RateProduct.Presenter.RateProductPresenter;
import com.example.myapplication.RateProduct.RateProductContract;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RateProductModel implements RateProductContract.Model {

    RateProductContract.Model.RateProductListener presenter;

    public RateProductModel(RateProductPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void RateProductAPI(RateInData data) {
        System.out.println("estoy en el model");
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<RateProductData> call = apiService.rateProduct("VALORACION.ADD", data.getUsuarioId(), data.getValoradoId(), data.getEstrellas(), data.getComentario(), data.getProductId());
        call.enqueue(new Callback<RateProductData>() {
            @Override
            public void onResponse(Call<RateProductData> call, Response<RateProductData> response) {
                if (response.isSuccessful()) {
                    if (response.body().getId() != 0){
                        presenter.SuccessRateProduct(response.body());
                    }else{
                        presenter.FailureRateProduct("Error al hacer la valoracion");
                    }
                    System.out.println(response.body().toString());
                } else {
                    presenter.FailureRateProduct("Error al hacer la valoracion");
                }
            }

            @Override
            public void onFailure(Call<RateProductData> call, Throwable t) {
                presenter.FailureRateProduct("Error al hacer la valoracion: "+ t.getMessage());

            }
        });
    }
}
