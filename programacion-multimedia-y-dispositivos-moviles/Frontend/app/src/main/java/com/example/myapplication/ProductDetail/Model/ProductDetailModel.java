package com.example.myapplication.ProductDetail.Model;

import com.example.myapplication.ProductDetail.Data.BuyData;
import com.example.myapplication.ProductDetail.Data.ProductDetailData;
import com.example.myapplication.ProductDetail.Data.ReturnBuyData;
import com.example.myapplication.ProductDetail.Presenter.ProductDetailPresenter;
import com.example.myapplication.ProductDetail.ProductDetailContract;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailModel implements ProductDetailContract.Model {
    private ProductDetailPresenter presenter;

    public ProductDetailModel(ProductDetailPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void LoadAddressesAPI(Integer userId) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<ArrayList<ProductDetailData>> call = apiService.getDirecciones("DIRECCION.FIND", userId);
        call.enqueue(new Callback<ArrayList<ProductDetailData>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductDetailData>> call, Response<ArrayList<ProductDetailData>> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().toString());
                    presenter.SuccessLoadAddresses(response.body());
                } else {
                    presenter.FailureLoadAddresses("Error al cargar las direcciones");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<ProductDetailData>> call, Throwable t) {
                presenter.FailureLoadAddresses("Error al cargar las direcciones");
            }
        });

    }

    @Override
    public void BuyAPI(BuyData buyData) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/app/").create(APIService.class);
        Call<ReturnBuyData> call = apiService.generateSale("VENTA.SELL", buyData.getComprador().getId(),
                buyData.getVendedor().getId(),
                buyData.getDireccion().getId(),
                buyData.getProducto().getUsuarioId());
        call.enqueue(new Callback<ReturnBuyData>() {
            @Override
            public void onResponse(Call<ReturnBuyData> call, Response<ReturnBuyData> response) {
                if (response.isSuccessful()) {
                    if (response.body().getVentaId() == 2){
                        presenter.SuccessBuy(response.body());
                    }else{
                        presenter.FailureBuy("Error al comprar el objeto");
                    }
                }
            }

            @Override
            public void onFailure(Call<ReturnBuyData> call, Throwable t) {
                System.out.println(t.getMessage());
                presenter.FailureBuy("Error al hacer la compra");
            }
        });
    }
}
