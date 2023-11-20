package com.example.myapplication.beans;

import java.sql.Date;

public class Producto {
    // ATRIBUTOS
    private Integer usuarioId;
    private String marca;
    private Double precio;
    private String descripcion;
    private String nombre;
    private String imagen;
    private String estado;
    private String color;

    // CONSTRUCTOR
    public Producto() {
    }

    public Producto(Integer usuarioId, String marca, Double precio, String descripcion, String nombre, String estado, String color) {
        this.usuarioId = usuarioId;
        this.marca = marca;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.estado = estado;
        this.color = color;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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

    @Override
    public String toString() {
        return "Producto{" +
                "usuarioId=" + usuarioId +
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


}
