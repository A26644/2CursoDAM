package com.example.myapplication.top.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.login.view.ViewLoginActivity;
import com.example.myapplication.top.ContractTop;
import com.example.myapplication.top.adapter.TopAdapter;
import com.example.myapplication.top.data.TopData;
import com.example.myapplication.top.presenter.TopPresenter;

import java.util.ArrayList;

public class TopViewActivity extends AppCompatActivity implements ContractTop.View {
    private TopPresenter topPresenter = new TopPresenter(this);
    private static TopViewActivity topViewActivity = null;
    private TopAdapter topAdapter;
    private ArrayList<TopData> lstUsers = new ArrayList<>();

    public static TopViewActivity getInstance() {
        return topViewActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_view);
        initComponentes();


    }



    private void initComponentes() {
        topPresenter.loadTop();
    }

    @Override
    public void onFinished(ArrayList<TopData> lstUsers) {
        this.lstUsers = lstUsers;
        RecyclerView recyclerView = findViewById(R.id.topRecycleView);
        topAdapter = new TopAdapter(this, lstUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(topAdapter);


    }

    @Override
    public void onFailure(String err) {
        Toast.makeText(TopViewActivity.this, "Error al cargar los usuarios con mas ventas", Toast.LENGTH_SHORT).show();

    }
}