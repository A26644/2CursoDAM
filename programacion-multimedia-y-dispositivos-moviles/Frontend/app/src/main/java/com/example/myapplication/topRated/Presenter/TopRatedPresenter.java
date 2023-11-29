package com.example.myapplication.topRated.Presenter;

import android.view.View;

import com.example.myapplication.topRated.Data.TopRatedData;
import com.example.myapplication.topRated.Model.TopRatedModel;
import com.example.myapplication.topRated.TopRatedContract;
import com.example.myapplication.topRated.View.TopRatedActivity;

import java.util.ArrayList;

public class TopRatedPresenter implements TopRatedContract.Presenter, TopRatedContract.Model.TopRatedListener {
    TopRatedContract.View view;
    TopRatedContract.Model model;

    public TopRatedPresenter(TopRatedActivity view) {
        this.view = view;
        model = new TopRatedModel(this);
    }

    @Override
    public void TopRated() {
        this.model.TopRatedAPI();

    }

    @Override
    public void TopRatedOnSuccess(ArrayList<TopRatedData> topRatedData) {
        view.TopRatedOnSuccess(topRatedData);
    }

    @Override
    public void TopRatedOnFailure(String err) {
        view.TopRatedOnFailure(err);
    }
}
