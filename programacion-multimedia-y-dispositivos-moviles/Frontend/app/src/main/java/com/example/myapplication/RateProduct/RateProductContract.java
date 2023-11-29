package com.example.myapplication.RateProduct;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.RateProduct.Data.RateInData;
import com.example.myapplication.RateProduct.Data.RateProductData;

public interface RateProductContract {
    public interface Model{
        public void RateProductAPI(RateInData data);
        public interface RateProductListener{
            public void SuccessRateProduct(RateProductData data);
            public void FailureRateProduct(String err);
        }
    }
    public interface Presenter{
        public void RateProduct(RateInData data);
    }
    public interface View{
        public void SuccessRateProduct(RateProductData data);
        public void FailureRateProduct(String err);
    }
}
