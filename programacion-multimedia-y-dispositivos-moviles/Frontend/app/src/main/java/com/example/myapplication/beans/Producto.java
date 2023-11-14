package com.example.myapplication.beans;

import java.sql.Date;

public class Producto {
    // ATRIBUTOS
    private int id;
    private int usuarioId;
    private String marca;
    private double precio;
    private Date fecha;
    private String descripcion;
    private String nombre;
    private String imagen;
    private String estado;
    private String color;

    // CONSTRUCTOR
    public Producto() {
    }

    public Producto(int usuarioId, String marca, double precio, Date fecha, String descripcion, String nombre,
                    String imagen, String estado, String color) {
        this.usuarioId = usuarioId;
        this.marca = marca;
        this.precio = precio;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.estado = estado;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", usuarioId=" + usuarioId + ", marca=" + marca + ", precio=" + precio
                + ", fecha=" + fecha + ", descripcion=" + descripcion + ", nombre=" + nombre + ", imagen=" + imagen
                + ", estado=" + estado + ", color=" + color + "]";
    }

    // METODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
