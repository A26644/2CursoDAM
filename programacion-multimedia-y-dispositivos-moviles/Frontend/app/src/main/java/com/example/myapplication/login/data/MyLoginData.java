package com.example.myapplication.login.data;

import com.example.myapplication.beans.Usuario;

import java.util.ArrayList;

public class MyData {
    private String message;
    private ArrayList<Usuario> lstUsuario;

    public String getMessage() {
        return message;
    }
    public ArrayList<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(ArrayList<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }
}
