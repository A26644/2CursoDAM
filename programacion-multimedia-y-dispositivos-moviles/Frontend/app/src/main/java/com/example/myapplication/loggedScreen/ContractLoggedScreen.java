package com.example.myapplication.loggedScreen;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;

import java.util.ArrayList;

public interface ContractLoggedScreen {
    public interface View{
        public void successLoadOnSale(ArrayList<OnLoadSaleData> lstSales);
        public void failureLoadOnSale(String err);
    }
    public interface Presenter{
        public void LoadOnSale(int userId);

    }
    public interface Model{
        public void loadOnSaleAPI(int userId, loadOnSaleListener loadOnSaleListener);
        public interface loadOnSaleListener{
            public void onFinished(ArrayList<OnLoadSaleData> lstSales);
            public void onFailure(String err);
        }

    }
}
