package com.example.myapplication.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.beans.Usuario;
import com.example.myapplication.login.ContractLogin;
import com.example.myapplication.login.presenter.PresenterLogin;

public class MainActivity extends AppCompatActivity implements ContractLogin.View {
    // ATRIBUTOS
    private PresenterLogin = new PresenterLogin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void successLogin(Usuario usuario) {

    }

    @Override
    public void failureLogin(String err) {

    }
}