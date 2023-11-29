package com.example.myapplication.ProductDetail.Data;

public class ReturnBuyData {
    Integer ventaId;

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    @Override
    public String toString() {
        return "ReturnBuyData{" +
                "ventaId=" + ventaId +
                '}';
    }
}
