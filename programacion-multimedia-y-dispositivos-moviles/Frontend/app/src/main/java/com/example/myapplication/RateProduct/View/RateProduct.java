package com.example.myapplication.RateProduct.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.BoughtProducts.View.MyBoughtProductsActivity;
import com.example.myapplication.R;
import com.example.myapplication.RateProduct.Data.RateInData;
import com.example.myapplication.RateProduct.Data.RateProductData;
import com.example.myapplication.RateProduct.Presenter.RateProductPresenter;
import com.example.myapplication.RateProduct.RateProductContract;
import com.example.myapplication.ViewAll.View.ViewAllActivity;
import com.example.myapplication.addProduct.view.AddProductActivity;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.top.view.TopViewActivity;
import com.example.myapplication.topRated.View.TopRatedActivity;

import java.io.Serializable;

public class RateProduct extends AppCompatActivity implements RateProductContract.View {
    RateProductContract.Presenter presenter = new RateProductPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_product);
        initComponents();
    }

    public void initComponents() {
        RateInData rateInData = new RateInData();
        Bundle extras = getIntent().getExtras();
        BoughtProductsData data;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            data = extras.getSerializable("detalle", BoughtProductsData.class);
        } else {
            data = null;
        }

        Button rateButton = findViewById(R.id.submitRateButton);
        rateButton.setOnClickListener(e -> {
            RatingBar ratingBar = findViewById(R.id.ratingBar);
            EditText comentario = findViewById(R.id.comentario);
            rateInData.setUsuarioId(extras.getInt("id"));
            rateInData.setValoradoId(data.getVendedor().getId());
            rateInData.setEstrellas(ratingBar.getNumStars());
            rateInData.setComentario(String.valueOf(comentario.getText()));
            rateInData.setProductId(data.getProducto().getUsuarioId());
            System.out.println(rateInData.toString());
            presenter.RateProduct(rateInData);
        });
    }

    @Override
    public void SuccessRateProduct(RateProductData data) {
        Toast.makeText(this, "¡Gracias por tu valoracion!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RateProduct.this, LoggedScreenActivity.class);
        intent.putExtra("id", getIntent().getExtras().getInt("id"));
        startActivity(intent);
    }

    @Override
    public void FailureRateProduct(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(RateProduct.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    PopupMenu subPopupMenu = new PopupMenu(RateProduct.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.products_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.addProduct) {
                                Intent intent = new Intent(RateProduct.this, AddProductActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(RateProduct.this, ViewAllActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            }
                            return false;
                        }
                    });
                    subPopupMenu.show();
                } else {
                    PopupMenu subPopupMenu = new PopupMenu(RateProduct.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.users_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            System.out.println("Esta es la ID que ha clickado: " +item.getItemId());
                            if (item.getItemId() == R.id.top10Sales) {
                                Intent intent = new Intent(RateProduct.this, TopViewActivity.class);
                                startActivity(intent);
                            } else if (item.getItemId() == R.id.myBoughtProducts) {
                                Intent intent = new Intent(RateProduct.this, MyBoughtProductsActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(RateProduct.this, TopRatedActivity.class);
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