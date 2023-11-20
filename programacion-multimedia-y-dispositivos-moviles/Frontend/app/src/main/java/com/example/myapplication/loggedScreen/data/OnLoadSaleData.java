package com.example.myapplication.loggedScreen.data;

import com.example.myapplication.beans.Direccion;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.beans.Usuario;
import com.example.myapplication.loggedScreen.model.OnLoadSaleModel;

import java.sql.Date;

public class OnLoadSaleData {
    // ATRIBUTOS
    private Integer id;
    private String marca;
    private Double precio;
    private String descripcion;
    private String nombre;
    private String fecha;
    private String imagen;
    private String estado;
    private String color;

    // CONSTRUCTOR
    public OnLoadSaleData() {
    }

    public OnLoadSaleData(String descripcion, String nombre, String imagen, String estado, String color) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.estado = estado;
        this.color = color;
    }


    @Override
    public String toString() {
        return "OnLoadSaleData{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado='" + estado + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    // METODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
