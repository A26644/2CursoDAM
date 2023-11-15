package com.example.myapplication.login.model;

import android.util.Log;

import com.example.myapplication.beans.Usuario;
import com.example.myapplication.login.ContractLogin;
import com.example.myapplication.login.data.MyLoginData;
import com.example.myapplication.login.presenter.PresenterLogin;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelLogin implements ContractLogin.Model {
    // ATRIBUTOS
    private static final String IP_BASE = "";
    private PresenterLogin presenter;
    // CONSTRUCTOR
    public ModelLogin(PresenterLogin presenter) {
        this.presenter = presenter;
    }
    // METODOS
    @Override
    public void loginAPI(Usuario usuario, onLoginUserListener onLoginUserListener) {
    APIService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/app/").create(APIService.class);

    Call<MyLoginData> call= apiService.getLogin("USUARIO.LOGIN");
    call.enqueue(new Callback<MyLoginData>() {
        @Override
        public void onResponse(Call<MyLoginData> call, Response<MyLoginData> response) {
            if (response.isSuccessful()){

                MyLoginData myLoginData = response.body();
                String message = myLoginData.getMessage();
                ArrayList<Usuario> lstUsuario = myLoginData.getLstUsuario();
                onLoginUserListener.onFinished(lstUsuario.get(0));
            }else{
                System.out.println("Ha habido un error");
            }
        }

        @Override
        public void onFailure(Call<MyLoginData> call, Throwable t) {
            Log.e("Response error", "Cuerpo del error: " + t.getMessage());

        }
    });
    }
}
