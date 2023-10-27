package model;

import java.sql.Date;

public class Ticket {
    private int id;
    private int numeroTarjeta;
    private int tipoTarjeta;
    private String titularTarjeta;
    private int tipoCompra;
    private Date fechaDevolucion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(int tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public int getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(int tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
