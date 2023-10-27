package model;

import java.util.Date;

public class ClienteFactura {
    private int clienteFacturaId;
    private boolean aceptado;
    private Date date;

    public int getClienteFacturaId() {
        return clienteFacturaId;
    }

    public void setClienteFacturaId(int clienteFacturaId) {
        this.clienteFacturaId = clienteFacturaId;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
