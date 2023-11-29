package com.example.myapplication.ViewAll;

import com.example.myapplication.ViewAll.Data.FilterProductsData;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.loggedScreen.data.CategoriaData;

import java.util.ArrayList;

public interface ViewAllContract {
    public interface Model {


        public interface ViewAllListener {
            public void ViewAllSuccess(ArrayList<ViewAllData> lstProduct);

            public void ViewAllFailure(String err);
        }

        public interface LoadCategoriesListener {
            public void successLoadCategories(ArrayList<CategoriaData> lstCategories);

            public void failureLoadCategories(String err);
        }
        public interface FilterProducts{
            public void successFilterProducts(ArrayList<ViewAllData> lstProduct);
            public void failureFilterProducts(String err);
        }

        public void ViewAllAPI(Integer userId);

        public void loadCategoriesAPI();
        public void filterProductsAPI(FilterProductsData filterProductsData);

    }

    public interface Presenter {

        public void ViewAll(Integer userId);

        public void loadCategories();
        public void filterProducts(FilterProductsData filterProductsData);
    }

    public interface View {
        public void ViewAllSuccess(ArrayList<ViewAllData> lstProduct);

        public void ViewAllFailure(String err);

        public void successLoadCategories(ArrayList<CategoriaData> lstCategories);

        public void failureLoadCategories(String err);
        public void successFilterProducts(ArrayList<ViewAllData> lstProduct);
        public void failureFilterProducts(String err);



    }
}
