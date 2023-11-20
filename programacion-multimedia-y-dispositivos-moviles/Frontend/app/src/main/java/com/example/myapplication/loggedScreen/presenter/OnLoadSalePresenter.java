package com.example.myapplication.loggedScreen.presenter;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.loggedScreen.model.OnLoadSaleModel;

import java.util.ArrayList;

public class OnLoadSalePresenter implements ContractLoggedScreen.Presenter, ContractLoggedScreen.Model.loadOnSaleListener {
    ContractLoggedScreen.View view;
    ContractLoggedScreen.Model model;
    public OnLoadSalePresenter(ContractLoggedScreen.View view ){
        this.view = view;
        model = new OnLoadSaleModel(this);
    }
    @Override
    public void LoadOnSale(int userId) {
        model.loadOnSaleAPI(userId, this);

    }

    @Override
    public void onFinished(ArrayList<OnLoadSaleData> lstSales) {
    view.successLoadOnSale(lstSales);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadOnSale(err);

    }
}
