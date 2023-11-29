package model;

import java.sql.Date;

public class Venta {
    private Integer ventaId;
    private Usuario vendedor;
    private Usuario comprador;
    private Direccion direccion;
    private Producto producto;
    private Date fechaVenta;
    private Boolean vendido;

    public int getVentaId() {
        return ventaId;
    }

    public Venta() {
    }

    public Venta(Usuario vendedor, Usuario comprador, Direccion direccion, Producto producto) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.direccion = direccion;
        this.producto = producto;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
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

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

}
