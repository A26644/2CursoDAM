package com.example.myapplication.ViewAll.Model;

import com.example.myapplication.ViewAll.Data.FilterProductsData;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.ViewAll.Presenter.ViewAllPresenter;
import com.example.myapplication.ViewAll.ViewAllContract;
import com.example.myapplication.loggedScreen.data.CategoriaData;
import com.example.myapplication.topRated.Data.TopRatedData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAllModel implements ViewAllContract.Model {
    ViewAllPresenter presenter;

    public ViewAllModel(ViewAllPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void ViewAllAPI(Integer userId) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<ArrayList<ViewAllData>> call = apiService.getAllProducts("PRODUCTO.FINDALL", userId);
        call.enqueue(new Callback<ArrayList<ViewAllData>>() {
            @Override
            public void onResponse(Call<ArrayList<ViewAllData>> call, Response<ArrayList<ViewAllData>> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().toString());
                    presenter.ViewAllSuccess(response.body());
                } else {
                    presenter.ViewAllFailure("Error al cargar productos");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<ViewAllData>> call, Throwable t) {
                presenter.ViewAllFailure("Error al cargar productos");

            }
        });

    }

    @Override
    public void loadCategoriesAPI() {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);

        Call<ArrayList<CategoriaData>> call = apiService.getCategories("CATEGORIA.FINDALL");
        call.enqueue(new Callback<ArrayList<CategoriaData>>() {
            @Override
            public void onResponse(Call<ArrayList<CategoriaData>> call, Response<ArrayList<CategoriaData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("Estoy en el success");
                    presenter.successLoadCategories(response.body());
                } else {
                    System.out.println("la peticion no ha sido exitosa");
                    presenter.failureLoadCategories("Error al cargar las categorias");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CategoriaData>> call, Throwable t) {
                System.out.println("la peticion no ha sido exitosa" + t.getMessage());
                presenter.failureLoadCategories("Error al cargar las categorias");
            }
        });
    }

    @Override
    public void filterProductsAPI(FilterProductsData filterProductsData) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<ArrayList<ViewAllData>> call = apiService.getFilterProducts("PRODUCTO.FINDFILTER", filterProductsData.getUserId() , filterProductsData.getFiltros(), filterProductsData.getFiltrosBusqueda());
        call.enqueue(new Callback<ArrayList<ViewAllData>>() {
            @Override
            public void onResponse(Call<ArrayList<ViewAllData>> call, Response<ArrayList<ViewAllData>> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().toString());
                    presenter.successFilterProducts(response.body());
                } else {
                    presenter.failureFilterProducts("Error al filtrar productos");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<ViewAllData>> call, Throwable t) {
                presenter.failureFilterProducts("Error al cargar productos");

            }
        });
    }


}
