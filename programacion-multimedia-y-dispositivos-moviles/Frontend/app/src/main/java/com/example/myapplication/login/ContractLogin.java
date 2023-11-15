package com.example.myapplication.login;

import com.example.myapplication.beans.Usuario;

public interface ContractLogin {
    public interface View {
        public void successLogin(Usuario usuario);

        public void failureLogin(String err);

    }

    public interface Presenter {
        public void login(Usuario usuario);

    }

    public interface Model {
        public interface onLoginUserListener {
            public void onFinished(Usuario usuario);

            public void onFailure(String err);
        }
        public void loginAPI(Usuario usuario, onLoginUserListener onLoginUserListener);

    }
}
