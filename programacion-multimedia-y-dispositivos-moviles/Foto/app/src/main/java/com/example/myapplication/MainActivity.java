package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.actions.ServicePeliculas;
import com.example.myapplication.actions.ViewPeliculas;

public class MainActivity extends AppCompatActivity implements ViewPeliculas {
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private ServicePeliculas sPeliculas = new ServicePeliculas(this);
// PATRON SINGLETON
    private static MainActivity mainActivity = null;
    public static MainActivity getInstance (){
        return mainActivity;
    }
// FIN PATRON SINGLETON
    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();


    }
    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void showPeliculas() {

    }
}