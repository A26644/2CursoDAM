package com.example.myapplication.top;

import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.top.data.TopData;

import java.util.ArrayList;

public interface ContractTop {
    public interface Model {


        public interface topListener {
            public void successTop(ArrayList<TopData> lstUsers);

            public void failureTop(String err);
        }
        public void topAPI(topListener topListener);

    }

    public interface Presenter {
        public void loadTop();


    }

    public interface View {
        public void onFinished(ArrayList<TopData> lstUsers);

        public void onFailure(String err);


    }
}
