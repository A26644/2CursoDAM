package com.example.myapplication.login.presenter;

import com.example.myapplication.beans.Usuario;
import com.example.myapplication.login.ContractLogin;
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
        System.out.println("Estoy en la view");
       model.loginAPI(usuario, this);




    }

    @Override
    public void onFinished(Usuario usuario) {
        view.successLogin(usuario);

    }

    @Override
    public void onFailure(String err) {
        System.out.println("Ha fallado en el presenter");
    }
}
