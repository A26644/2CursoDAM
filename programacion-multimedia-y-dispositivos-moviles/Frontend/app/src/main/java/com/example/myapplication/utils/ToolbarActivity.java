package com.example.myapplication.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        ImageView backArrow = findViewById(R.id.backArrow);
        ImageView hamburgerMenu = findViewById(R.id.hamburgerMenu);
        backArrow.setOnClickListener(e -> {
            Toast.makeText(this, "Has pulsado la flecha hacia atras", Toast.LENGTH_SHORT).show();
        });
        hamburgerMenu.setOnClickListener(e -> {
            Toast.makeText(this, "Has pulsado el menu hamburguesa", Toast.LENGTH_SHORT).show();
        });
    }
}