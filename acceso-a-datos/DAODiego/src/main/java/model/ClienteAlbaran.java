package model;

import java.util.Date;

public class ClienteAlbaran {
    private int clienteAlbaranId;
    private boolean aceptado;
    private Date fecha;

    public int getClienteAlbaranId() {
        return clienteAlbaranId;
    }

    public void setClienteAlbaranId(int clienteAlbaranId) {
        this.clienteAlbaranId = clienteAlbaranId;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
