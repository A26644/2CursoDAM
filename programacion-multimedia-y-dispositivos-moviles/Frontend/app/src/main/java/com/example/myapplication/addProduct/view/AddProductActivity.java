package com.example.myapplication.addProduct.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.addProduct.presenter.AddProductPresenter;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.login.view.ViewLoginActivity;

public class AddProductActivity extends AppCompatActivity implements ContractAddProduct.View {
    AddProductPresenter productPresenter = new AddProductPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        initComponents();
    }
    public void initComponents(){
        EditText brand = findViewById(R.id.addBrand);
        EditText name = findViewById(R.id.addName);
        EditText desc = findViewById(R.id.addDesc);
        EditText color = findViewById(R.id.addColor);
        EditText state = findViewById(R.id.addState);
        EditText price = findViewById(R.id.addPrice);
        Button addProductButton = findViewById(R.id.addProductButton);

        addProductButton.setOnClickListener(e -> {
            Bundle extras = getIntent().getExtras();
            Producto producto = new Producto();
            producto.setUsuarioId(extras.getInt("id"));
            producto.setMarca(String.valueOf(brand.getText()));
            producto.setNombre(String.valueOf(name.getText()));
            producto.setDescripcion(String.valueOf(desc.getText()));
            producto.setColor(String.valueOf(color.getText()));
            producto.setEstado(String.valueOf(state.getText()));
            producto.setPrecio(Double.parseDouble(price.getText().toString()));
            System.out.println(producto.toString());
            productPresenter.addProduct(producto);
        });
    }


    @Override
    public void onSuccessAddProduct(AddProductData addProductData) {
        Toast.makeText(this, "Producto añadido con exito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddProductActivity.this, LoggedScreenActivity.class);
        intent.putExtra("id", getIntent().getExtras().getInt("id"));
        startActivity(intent);
    }

    @Override
    public void onFailureAddProduct(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();

    }
}