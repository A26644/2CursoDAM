package com.example.myapplication.utils;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.ProductDetail.Data.ProductDetailData;
import com.example.myapplication.ProductDetail.Data.ReturnBuyData;
import com.example.myapplication.RateProduct.Data.RateProductData;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.beans.Usuario;
import com.example.myapplication.loggedScreen.data.CategoriaData;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.login.data.MyLoginData;
import com.example.myapplication.top.data.TopData;
import com.example.myapplication.topRated.Data.TopRatedData;

import java.util.ArrayList;

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
    Call<MyLoginData> getLogin(@Query("ACTION") String action, @Query("EMAIL") String nombre, @Query("PASS") String pass);

    @GET("Controller")
    Call<ArrayList<OnLoadSaleData>> getMySales(@Query("ACTION") String action, @Query("USUARIOID") Integer userId);

    @GET("Controller")
    Call<AddProductData> getMySales(@Query("ACTION") String action,
                                    @Query("USUARIOID") Integer userId,
                                    @Query("MARCA") String marca,
                                    @Query("PRECIO") Double precio,
                                    @Query("DESCRIPCION") String descripcion,
                                    @Query("NOMBRE") String nombre,
                                    @Query("IMAGEN") String imagen,
                                    @Query("ESTADO") String estado,
                                    @Query("COLOR") String color);

    @GET("Controller")
    Call<ArrayList<TopData>> getMostUsers(@Query("ACTION") String action);

    @GET("Controller")
    Call<ArrayList<TopRatedData>> GetMostRatedUsers(@Query("ACTION") String action);

    @GET("Controller")
    Call<ArrayList<ViewAllData>> getAllProducts(@Query("ACTION") String action, @Query("USUARIOID") Integer userId);

    @GET("Controller")
    Call<ArrayList<ProductDetailData>> getDirecciones(@Query("ACTION") String action,
                                                      @Query("USUARIOID") Integer userId);

    @GET("Controller")
    Call<ReturnBuyData> generateSale(@Query("ACTION") String action,
                                     @Query("COMPRADORID") Integer compradorId,
                                     @Query("VENDEDORID") Integer vendedorId,
                                     @Query("DIRECCIONID") Integer direccionId,
                                     @Query("PRODUCTOID") Integer productoId);
    @GET("Controller")
    Call<ArrayList<BoughtProductsData>> getMyBoughtProducts(@Query("ACTION") String action,
                                                 @Query("USUARIOID") Integer userId);
    @GET("Controller")
    Call<RateProductData> rateProduct (@Query("ACTION") String action,
                                       @Query("USUARIOID") Integer userId,
                                       @Query("VALORADOID") Integer valoradoId,
                                       @Query("ESTRELLA") Integer stars,
                                       @Query("COMENTARIO") String comentario,
                                       @Query("PRODUCTOID") Integer productId);
    @GET("Controller")
    Call<ArrayList<CategoriaData>> getCategories(@Query("ACTION") String action);
    @GET("Controller")
    Call<ArrayList<ViewAllData>> getFilterProducts(@Query("ACTION") String action,
                                                   @Query("USUARIOID") Integer userId,
                                                   @Query("FILTER") String filter,
                                                   @Query("FILTERNAME") String filterName);







}
