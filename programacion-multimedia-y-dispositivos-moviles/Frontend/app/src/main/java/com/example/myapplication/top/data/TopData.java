package com.example.myapplication.top.data;

public class TopData {
    Integer numeroVentas;
    Integer id;
    String nombre;
    String apellido1;
    String apellido2;
    String email;

    public Integer getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(Integer numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TopData{" +
                "numeroVentas=" + numeroVentas +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
