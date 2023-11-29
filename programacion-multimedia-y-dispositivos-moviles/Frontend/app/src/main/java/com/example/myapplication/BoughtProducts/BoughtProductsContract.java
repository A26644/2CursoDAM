package com.example.myapplication.BoughtProducts;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;

import java.util.ArrayList;

public interface BoughtProductsContract {
    public interface View{
        public void SuccessMyBoughtProducts(ArrayList<BoughtProductsData> lstProducts);
        public void FailureMyBoughtProducts(String err);

    }
    public interface Presenter{
        public void MyBoughtProducts(Integer userId);
    }
    public interface Model{
        public void MyBoughtProductsAPI(Integer userId);

        public interface MyBoughtProductsListener{
            public void SuccessMyBoughtProducts(ArrayList<BoughtProductsData> lstProducts);
            public void FailureMyBoughtProducts(String err);
        }

    }
}
