package com.example.myapplication.login.data;

import com.example.myapplication.beans.Usuario;

import java.util.ArrayList;

public class MyLoginData {
    Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyLoginData{" +
                "id=" + id +
                '}';
    }
}
