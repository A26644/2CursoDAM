package com.example.myapplication.ProductDetail.Presenter;

import com.example.myapplication.ProductDetail.Data.BuyData;
import com.example.myapplication.ProductDetail.Data.ProductDetailData;
import com.example.myapplication.ProductDetail.Data.ReturnBuyData;
import com.example.myapplication.ProductDetail.Model.ProductDetailModel;
import com.example.myapplication.ProductDetail.ProductDetailContract;
import com.example.myapplication.ProductDetail.View.ProductDetailActivity;

import java.util.ArrayList;

public class ProductDetailPresenter implements ProductDetailContract.Presenter, ProductDetailContract.Model.LoadAddressesListener, ProductDetailContract.Model.BuyListener {
    ProductDetailContract.View view;
    ProductDetailContract.Model model;

    public ProductDetailPresenter(ProductDetailActivity view) {
        this.view = view;
        model = new ProductDetailModel(this);

    }

    @Override
    public void LoadAddresses(Integer userId) {
        model.LoadAddressesAPI(userId);
    }

    @Override
    public void BuyButton(BuyData buydata) {
        model.BuyAPI(buydata);
    }

    @Override
    public void SuccessLoadAddresses(ArrayList<ProductDetailData> lstDirecciones) {
        view.SuccessLoadAddresses(lstDirecciones);
    }

    @Override
    public void FailureLoadAddresses(String err) {
        view.FailureLoadAddresses(err);

    }

    @Override
    public void SuccessBuy(ReturnBuyData returnBuyData) {
        view.SuccessBuy(returnBuyData);
    }

    @Override
    public void FailureBuy(String err) {
        view.FailureBuy(err);
    }
}
