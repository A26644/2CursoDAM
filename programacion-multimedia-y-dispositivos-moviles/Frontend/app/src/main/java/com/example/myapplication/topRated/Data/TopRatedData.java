package com.example.myapplication.topRated.Data;

import com.example.myapplication.beans.Usuario;

public class TopRatedData {

    Usuario usuario;
    Integer estrellas;

    @Override
    public String toString() {
        return "TopRatedData{" +
                "usuario=" + usuario.toString() +
                ", estrellas=" + estrellas +
                '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }
}
