package com.example.myapplication.utils;

import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class HeaderFunctionality extends AppCompatActivity {
    public void SetHeaderFunctionality(){
        // CAPTURAR LOS DATOS DEL HEADER
        ImageView backArrow = findViewById(R.id.backArrow);
        ImageView hamburgerMenu = findViewById(R.id.hamburgerMenu);
        backArrow.setOnClickListener(e -> {
            Toast.makeText(this, "Has pulsado el boton de ir hacia atras", Toast.LENGTH_SHORT).show();
        });
        hamburgerMenu.setOnClickListener(e -> {
            Toast.makeText(this, "Has pulsado el boton de la hamburguesa", Toast.LENGTH_SHORT).show();
        });

    }
}
