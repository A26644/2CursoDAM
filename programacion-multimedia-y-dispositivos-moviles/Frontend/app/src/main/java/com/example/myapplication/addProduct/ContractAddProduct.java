package com.example.myapplication.addProduct;

import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.beans.Producto;

public interface ContractAddProduct {
    public interface Model{
        public interface AddProductListener{
            public void onFinishedAddProduct(AddProductData addProductData);
            public void onFailureAddProduct(String err);
        }
        public void addProductAPI(Producto producto, AddProductListener addProductListener);
    }
    public interface Presenter{
        public void addProduct(Producto producto);

    }
    public interface View{
        public void onSuccessAddProduct(AddProductData addProductData);
        public void onFailureAddProduct(String err);

    }
}
