package com.example.myapplication.addProduct.presenter;

import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.addProduct.model.AddProductModel;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;

public class AddProductPresenter implements ContractAddProduct.Presenter, ContractAddProduct.Model.AddProductListener {
    ContractAddProduct.View view;
    ContractAddProduct.Model model;
    public AddProductPresenter(ContractAddProduct.View view){
        this.view = view;
        model = new AddProductModel(this);
    }
    @Override
    public void onFinishedAddProduct(AddProductData addProductData) {
        view.onSuccessAddProduct(addProductData);

    }

    @Override
    public void onFailureAddProduct(String err) {
        view.onFailureAddProduct(err);
    }

    @Override
    public void addProduct(Producto producto) {
        model.addProductAPI(producto, this);
    }
}
