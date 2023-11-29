package com.example.myapplication.addProduct.model;

import android.util.Log;

import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductModel implements ContractAddProduct.Model{
    ContractAddProduct.Presenter presenter;

    public AddProductModel(ContractAddProduct.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addProductAPI(Producto producto, AddProductListener addProductListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<AddProductData> call = apiService.getMySales("PRODUCTO.ADD",producto.getUsuarioId(),
                producto.getMarca(),
                producto.getPrecio(),
                producto.getDescripcion(),
                producto.getNombre(),
                producto.getImagen(),
                producto.getEstado(),
                producto.getColor());
        call.enqueue(new Callback<AddProductData>() {
            @Override
            public void onResponse(Call<AddProductData> call, Response<AddProductData> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                    if (response.body().getId() == 1){
                        addProductListener.onFinishedAddProduct(response.body());
                    }else{
                        addProductListener.onFailureAddProduct("Error al añadir el producto");

                    }
                }
            }

            @Override
            public void onFailure(Call<AddProductData> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
