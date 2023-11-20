package com.example.myapplication.login;

import com.example.myapplication.beans.Usuario;
import com.example.myapplication.login.data.MyLoginData;

public interface ContractLogin {
    public interface View {
        public void successLogin(MyLoginData myLoginData);

        public void failureLogin(String err);

    }

    public interface Presenter {
        public void login(Usuario usuario);

    }

    public interface Model {
        public interface onLoginUserListener {
            public void onFinished(MyLoginData myLoginData);

            public void onFailure(String err);
        }
        public void loginAPI(Usuario usuario, onLoginUserListener onLoginUserListener);

    }
}
