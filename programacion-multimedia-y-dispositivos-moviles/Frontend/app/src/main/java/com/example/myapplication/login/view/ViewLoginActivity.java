package com.example.myapplication.login.view;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.window.SplashScreen;

import com.example.myapplication.R;
import com.example.myapplication.beans.Usuario;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.login.ContractLogin;
import com.example.myapplication.login.presenter.PresenterLogin;

public class ViewLogin extends AppCompatActivity implements ContractLogin.View {
    // ATRIBUTOS
    private PresenterLogin presenterLogin = new PresenterLogin(this);
    // PATRON SINGLETON
    private static ViewLogin mainActivity = null;

    // METODOS
    public static ViewLogin getInstance() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

    }

    public void initComponents() {
        Button loginButton = findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText loginEmail = findViewById(R.id.LoginEmail);
                String loginEmailText = loginEmail.getText().toString();
                EditText loginPass = findViewById(R.id.LoginPass);
                String loginPassText = loginPass.getText().toString();
                Usuario usuario = new Usuario(loginEmailText, loginPassText);
                presenterLogin.login(usuario);

            }
        });
    }


    @Override
    public void successLogin(Usuario usuario) {
        Intent intent = new Intent(this, LoggedScreenActivity.class);
        startActivity(intent);

    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(ViewLogin.this, err, Toast.LENGTH_SHORT).show();
    }
}