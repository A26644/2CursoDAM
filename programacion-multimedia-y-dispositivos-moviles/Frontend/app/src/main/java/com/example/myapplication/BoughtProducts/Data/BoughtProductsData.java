package com.example.myapplication.BoughtProducts.Data;

import com.example.myapplication.beans.Direccion;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.beans.Usuario;

import java.io.Serializable;

public class BoughtProductsData implements Serializable {
    Integer ventaId;
    Usuario vendedor;
    Direccion direccion;
    Producto producto;

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaÏd) {
        this.ventaId = ventaÏd;
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

    @Override
    public String toString() {
        return "BoughtProductsData{" +
                "ventaÏd=" + ventaId.toString() +
                ", vendedor=" + vendedor.toString() +
                ", direccion=" + direccion.toString() +
                ", producto=" + producto.toString() +
                '}';
    }
}
