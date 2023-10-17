package model;

import java.sql.Date;

public class Albaran {
    private int albaranId;
    private int albaranPedidoId;
    private Date albaranFecha;

    public int getAlbaranId() {
        return albaranId;
    }

    public void setAlbaranId(int albaranId) {
        this.albaranId = albaranId;
    }

    public int getAlbaranPedidoId() {
        return albaranPedidoId;
    }

    public void setAlbaranPedidoId(int albaranPedidoId) {
        this.albaranPedidoId = albaranPedidoId;
    }

    public Date getAlbaranFecha() {
        return albaranFecha;
    }

    public void setAlbaranFecha(Date albaranFecha) {
        this.albaranFecha = albaranFecha;
    }
}
