package com.example.myapplication.addProduct.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.View.MyBoughtProductsActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewAll.View.ViewAllActivity;
import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.addProduct.presenter.AddProductPresenter;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.login.view.ViewLoginActivity;
import com.example.myapplication.top.view.TopViewActivity;
import com.example.myapplication.topRated.View.TopRatedActivity;

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
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(AddProductActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    PopupMenu subPopupMenu = new PopupMenu(AddProductActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.products_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.addProduct) {
                                Intent intent = new Intent(AddProductActivity.this, AddProductActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(AddProductActivity.this, ViewAllActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            }
                            return false;
                        }
                    });
                    subPopupMenu.show();
                } else {
                    PopupMenu subPopupMenu = new PopupMenu(AddProductActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.users_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            System.out.println("Esta es la ID que ha clickado: " +item.getItemId());
                            if (item.getItemId() == R.id.top10Sales) {
                                Intent intent = new Intent(AddProductActivity.this, TopViewActivity.class);
                                startActivity(intent);
                            } else if (item.getItemId() == R.id.myBoughtProducts) {
                                Intent intent = new Intent(AddProductActivity.this, MyBoughtProductsActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(AddProductActivity.this, TopRatedActivity.class);
                                startActivity(intent);
                            }

                            return false;
                        }
                    });
                    subPopupMenu.show();
                }
                return false;
            }
        });
        popupMenu.show();
    }
}