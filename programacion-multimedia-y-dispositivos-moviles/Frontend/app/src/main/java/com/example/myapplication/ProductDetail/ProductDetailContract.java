package com.example.myapplication.ProductDetail;

import com.example.myapplication.ProductDetail.Data.BuyData;
import com.example.myapplication.ProductDetail.Data.ProductDetailData;
import com.example.myapplication.ProductDetail.Data.ReturnBuyData;

import java.util.ArrayList;

public interface ProductDetailContract {
    public interface View{
        public void SuccessLoadAddresses(ArrayList<ProductDetailData> lstDirecciones);
        public void FailureLoadAddresses(String err);
        public void SuccessBuy(ReturnBuyData returnBuyData);
        public void FailureBuy(String err);
    }
    public interface Presenter{
        public void LoadAddresses(Integer userId);
        public void BuyButton(BuyData buyData);

    }
    public interface Model{
        public void LoadAddressesAPI(Integer userId);
        public interface LoadAddressesListener{
            public void SuccessLoadAddresses(ArrayList<ProductDetailData> lstDirecciones);
            public void FailureLoadAddresses(String err);
        }
        public void BuyAPI(BuyData buyData);
        public interface BuyListener{
            public void SuccessBuy(ReturnBuyData returnBuyData);
            public void FailureBuy(String err);
        }
    }
}
