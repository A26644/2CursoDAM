package com.example.myapplication.ProductDetail.Data;

import com.example.myapplication.beans.Direccion;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.beans.Usuario;

public class BuyData {
    Usuario comprador;
    Usuario vendedor;
    Direccion direccion;
    Producto producto;

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
