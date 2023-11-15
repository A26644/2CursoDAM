package com.example.myapplication.login.data;

import com.example.myapplication.beans.Usuario;

import java.util.ArrayList;

public class MyLoginData {
    int id;
    String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyLoginData{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
