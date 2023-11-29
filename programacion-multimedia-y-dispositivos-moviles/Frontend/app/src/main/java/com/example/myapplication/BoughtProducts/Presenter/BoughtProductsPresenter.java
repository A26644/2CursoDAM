package com.example.myapplication.BoughtProducts.Presenter;

import com.example.myapplication.BoughtProducts.BoughtProductsContract;
import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.BoughtProducts.Model.BoughtProductsModel;
import com.example.myapplication.BoughtProducts.View.MyBoughtProductsActivity;

import java.util.ArrayList;

public class BoughtProductsPresenter implements BoughtProductsContract.Presenter, BoughtProductsContract.Model.MyBoughtProductsListener {
    BoughtProductsContract.View view;
    BoughtProductsContract.Model model;

    public BoughtProductsPresenter(MyBoughtProductsActivity view) {
        this.view = view;
        model = new BoughtProductsModel(this);
    }

    @Override
    public void MyBoughtProducts(Integer userId) {
        this.model.MyBoughtProductsAPI(userId);
    }

    @Override
    public void SuccessMyBoughtProducts(ArrayList<BoughtProductsData> lstProducts) {
        view.SuccessMyBoughtProducts(lstProducts);
    }

    @Override
    public void FailureMyBoughtProducts(String err) {
        view.FailureMyBoughtProducts(err);
    }
}
