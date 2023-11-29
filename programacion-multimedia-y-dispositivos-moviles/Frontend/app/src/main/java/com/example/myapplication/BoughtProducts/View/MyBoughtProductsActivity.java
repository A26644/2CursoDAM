package com.example.myapplication.BoughtProducts.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.Adapter.BoughtProductsAdapter;
import com.example.myapplication.BoughtProducts.BoughtProductsContract;
import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.BoughtProducts.Presenter.BoughtProductsPresenter;
import com.example.myapplication.R;
import com.example.myapplication.ViewAll.Adapter.ViewAllAdapter;
import com.example.myapplication.ViewAll.Data.ViewAllData;

import java.util.ArrayList;

public class MyBoughtProductsActivity extends AppCompatActivity implements BoughtProductsContract.View {
    BoughtProductsContract.Presenter presenter = new BoughtProductsPresenter(this);
    private BoughtProductsAdapter boughtProductsAdapter;
    private ArrayList<BoughtProductsData> boughtProductsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bought_products);
        initComponents();
    }

    private void initComponents() {
        presenter.MyBoughtProducts(getIntent().getExtras().getInt("id"));
    }

    @Override
    public void SuccessMyBoughtProducts(ArrayList<BoughtProductsData> lstProducts) {
        this.boughtProductsData = lstProducts;
        RecyclerView recyclerView = findViewById(R.id.boughtProductsRecycler);
        boughtProductsAdapter = new BoughtProductsAdapter(this, lstProducts, getIntent());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(boughtProductsAdapter);
    }

    @Override
    public void FailureMyBoughtProducts(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}