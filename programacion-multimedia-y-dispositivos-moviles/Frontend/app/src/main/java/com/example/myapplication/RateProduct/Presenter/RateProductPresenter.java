package com.example.myapplication.RateProduct.Presenter;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.RateProduct.Data.RateInData;
import com.example.myapplication.RateProduct.Data.RateProductData;
import com.example.myapplication.RateProduct.Model.RateProductModel;
import com.example.myapplication.RateProduct.RateProductContract;
import com.example.myapplication.RateProduct.View.RateProduct;

public class RateProductPresenter implements RateProductContract.Presenter, RateProductContract.Model.RateProductListener {
    RateProductContract.View view;
    RateProductContract.Model model;

    public RateProductPresenter(RateProduct view) {
        this.view = view;
        model = new RateProductModel(this);
    }

    @Override
    public void SuccessRateProduct(RateProductData data) {
        view.SuccessRateProduct(data);
    }

    @Override
    public void FailureRateProduct(String err) {
        view.FailureRateProduct(err);
    }

    @Override
    public void RateProduct(RateInData data) {
        model.RateProductAPI(data);

    }
}
