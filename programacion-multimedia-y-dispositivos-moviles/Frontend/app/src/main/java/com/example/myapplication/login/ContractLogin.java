package com.example.myapplication.login;

public interface ContractLogin {
    public interface View {
        public void successLogin();

        public void failureLogin();

    }

    public interface Presenter {
        public void login();

    }

    public interface Model {
        public interface onLoginUserListener {
            public void onFinished();

            public void onFailure();
        }
        public void loginAPI();

    }
}
