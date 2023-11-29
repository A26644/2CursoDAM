package com.example.myapplication.topRated;

import com.example.myapplication.topRated.Data.TopRatedData;

import java.util.ArrayList;

public interface TopRatedContract {
    public interface View{
        public void TopRatedOnSuccess(ArrayList<TopRatedData> topRatedData);
        public void TopRatedOnFailure(String err);
    }
    public interface Presenter{
        public void TopRated();
    }
    public interface Model{
        public interface TopRatedListener{
            public void TopRatedOnSuccess(ArrayList<TopRatedData> topRatedData);
            public void TopRatedOnFailure(String err);
        }
        public void TopRatedAPI();

    }
}

