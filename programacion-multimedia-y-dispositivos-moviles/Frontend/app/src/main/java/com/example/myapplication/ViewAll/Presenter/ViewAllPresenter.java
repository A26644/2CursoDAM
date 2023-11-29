package com.example.myapplication.ViewAll.Presenter;

import com.example.myapplication.ViewAll.Data.FilterProductsData;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.ViewAll.Model.ViewAllModel;
import com.example.myapplication.ViewAll.ViewAllContract;
import com.example.myapplication.loggedScreen.data.CategoriaData;

import java.util.ArrayList;

public class ViewAllPresenter implements ViewAllContract.Presenter, ViewAllContract.Model.ViewAllListener, ViewAllContract.Model.LoadCategoriesListener, ViewAllContract.Model.FilterProducts {
    ViewAllContract.View view;
    ViewAllContract.Model model;

    public ViewAllPresenter(ViewAllContract.View view) {
        this.view = view;
        model = new ViewAllModel(this);
    }

    @Override
    public void ViewAll(Integer userId) {
        this.model.ViewAllAPI(userId);
    }

    @Override
    public void loadCategories() {
        System.out.println("Estoy cargando en el presenter");
        model.loadCategoriesAPI();
    }

    @Override
    public void filterProducts(FilterProductsData filterProductsData) {
        model.filterProductsAPI(filterProductsData);
    }


    @Override
    public void ViewAllSuccess(ArrayList<ViewAllData> lstProduct) {
        view.ViewAllSuccess(lstProduct);
    }

    @Override
    public void ViewAllFailure(String err) {
        view.ViewAllFailure(err);
    }

    @Override
    public void successLoadCategories(ArrayList<CategoriaData> lstCategories) {
        view.successLoadCategories(lstCategories);
    }

    @Override
    public void failureLoadCategories(String err) {
        view.failureLoadCategories(err);
    }

    @Override
    public void successFilterProducts(ArrayList<ViewAllData> lstProduct) {
        view.successFilterProducts(lstProduct);
    }

    @Override
    public void failureFilterProducts(String err) {
        view.failureFilterProducts(err);
    }
}
