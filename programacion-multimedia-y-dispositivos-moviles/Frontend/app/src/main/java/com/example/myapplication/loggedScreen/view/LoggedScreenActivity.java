package com.example.myapplication.loggedScreen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.addProduct.presenter.AddProductPresenter;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.loggedScreen.adapter.OnSaleDataAdapter;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.loggedScreen.presenter.OnLoadSalePresenter;
import com.example.myapplication.login.view.ViewLoginActivity;
import com.example.myapplication.top.ContractTop;
import com.example.myapplication.top.view.TopViewActivity;

import java.util.ArrayList;

public class LoggedScreenActivity extends AppCompatActivity implements ContractLoggedScreen.View, ContractAddProduct.View {
    private OnLoadSalePresenter presenter = new OnLoadSalePresenter(this);
    private AddProductPresenter addProductPresenter = new AddProductPresenter(this);
    private static LoggedScreenActivity mainActivity = null;
    public OnSaleDataAdapter onSaleDataAdapter;
    private ArrayList<OnLoadSaleData> lstSales;
    private Integer userId;

    public static LoggedScreenActivity getInstance() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_screen);
        initComponents();

    }

    public void initComponents() {
        Bundle extras = getIntent().getExtras();
        presenter.LoadOnSale(extras.getInt("id"));
        Button button = findViewById(R.id.addProductButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText addName = findViewById(R.id.addName);
                EditText addBrand = findViewById(R.id.addBrand);
                EditText addPrice = findViewById(R.id.addPrice);
                EditText addDesc = findViewById(R.id.addDesc);
                EditText addState = findViewById(R.id.addState);
                EditText addColor = findViewById(R.id.addColor);
                String addNameStr = String.valueOf(addName.getText());
                String addBrandStr = String.valueOf(addBrand.getText());
                Double addPriceStr = Double.parseDouble(String.valueOf(addPrice.getText()));
                String addDescStr = String.valueOf(addDesc.getText());
                String addStateStr = String.valueOf(addState.getText());
                String addColorStr = String.valueOf(addColor.getText());
                Producto producto = new Producto(extras.getInt("id"),addBrandStr, addPriceStr, addDescStr, addNameStr, addStateStr, addColorStr);
                System.out.println(producto.toString());
                addProductPresenter.addProduct(producto);

            }
        });
        Button findMostButton = findViewById(R.id.redirectTop10);
        findMostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedScreenActivity.this, TopViewActivity.class);

                startActivity(intent);
            }
        });


    }

    @Override
    public void successLoadOnSale(ArrayList<OnLoadSaleData> lstSales) {
        this.lstSales = lstSales;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        onSaleDataAdapter = new OnSaleDataAdapter(this, lstSales);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(onSaleDataAdapter);


    }

    @Override
    public void failureLoadOnSale(String err) {
        Toast.makeText(LoggedScreenActivity.this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessAddProduct(AddProductData addProductData) {
        Toast.makeText(LoggedScreenActivity.this, "Producto correctamente añadido", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureAddProduct(String err) {
        Toast.makeText(LoggedScreenActivity.this, err, Toast.LENGTH_SHORT).show();
    }
}