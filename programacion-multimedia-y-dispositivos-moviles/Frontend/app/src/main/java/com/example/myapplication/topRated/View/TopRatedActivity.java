package com.example.myapplication.topRated.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.top.adapter.TopAdapter;
import com.example.myapplication.topRated.Adapter.TopRatedAdapter;
import com.example.myapplication.topRated.Data.TopRatedData;
import com.example.myapplication.topRated.Presenter.TopRatedPresenter;
import com.example.myapplication.topRated.TopRatedContract;

import java.util.ArrayList;

public class TopRatedActivity extends AppCompatActivity implements TopRatedContract.View {
    TopRatedPresenter topRatedPresenter = new TopRatedPresenter(this);
    private ArrayList<TopRatedData> lstTopRatedData = new ArrayList<>();
    private TopRatedAdapter topRatedAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated);
        initComponents();
    }
    private void initComponents(){
        topRatedPresenter.TopRated();
    }

    @Override
    public void TopRatedOnSuccess(ArrayList<TopRatedData> topRatedData) {
        System.out.println("Estoy intentando hacer el adapter");
            this.lstTopRatedData = topRatedData;
        RecyclerView recyclerView = findViewById(R.id.TopRatedRecycler);
        topRatedAdapter = new TopRatedAdapter(this, topRatedData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(topRatedAdapter);
    }

    @Override
    public void TopRatedOnFailure(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}