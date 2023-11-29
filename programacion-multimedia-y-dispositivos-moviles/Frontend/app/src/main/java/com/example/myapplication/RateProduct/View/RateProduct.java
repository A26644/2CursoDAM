package com.example.myapplication.RateProduct.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.R;
import com.example.myapplication.RateProduct.Data.RateInData;
import com.example.myapplication.RateProduct.Data.RateProductData;
import com.example.myapplication.RateProduct.Presenter.RateProductPresenter;
import com.example.myapplication.RateProduct.RateProductContract;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;

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
}