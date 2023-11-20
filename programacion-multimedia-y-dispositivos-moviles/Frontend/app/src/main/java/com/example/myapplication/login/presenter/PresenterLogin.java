package com.example.myapplication.login.presenter;

import com.example.myapplication.beans.Usuario;
import com.example.myapplication.login.ContractLogin;
import com.example.myapplication.login.data.MyLoginData;
import com.example.myapplication.login.model.ModelLogin;

public class PresenterLogin implements ContractLogin.Presenter, ContractLogin.Model.onLoginUserListener {
    // ATRIBUTOS
    private ContractLogin.View view;
    private ContractLogin.Model model;


    // CONSTRUCTOR

    public PresenterLogin(ContractLogin.View view) {
        this.view = view;
        model = new ModelLogin(this);

    }

    // METODOS

    @Override
    public void login(Usuario usuario) {
       model.loginAPI(usuario, this);

    }

    @Override
    public void onFinished(MyLoginData myLoginData) {
        view.successLogin(myLoginData);

    }

    @Override
    public void onFailure(String err) {
        view.failureLogin(err);
    }
}
