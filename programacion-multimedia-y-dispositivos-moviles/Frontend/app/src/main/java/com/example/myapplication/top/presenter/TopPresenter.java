package com.example.myapplication.top.presenter;

import android.view.View;

import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.top.ContractTop;
import com.example.myapplication.top.data.TopData;
import com.example.myapplication.top.model.TopModel;
import com.example.myapplication.top.view.TopViewActivity;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class TopPresenter implements ContractTop.Presenter, ContractTop.Model.topListener {
    private ContractTop.View view;
    private ContractTop.Model model;

    public TopPresenter(TopViewActivity view){
        this.view = view;
        model = new TopModel(this);
    }
    @Override
    public void loadTop() {
        this.model.topAPI(this);


    }

    @Override
    public void successTop(ArrayList<TopData> lstUsers) {
        view.onFinished(lstUsers);
    }

    @Override
    public void failureTop(String err) {
    view.onFailure(err);
    }
}
