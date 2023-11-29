package com.example.myapplication.RateProduct.Data;

public class RateInData {
    Integer usuarioId;
    Integer valoradoId;
    Integer estrellas;
    Integer productId;
    String comentario;


    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getValoradoId() {
        return valoradoId;
    }

    public void setValoradoId(Integer valoradoId) {
        this.valoradoId = valoradoId;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "RateInData{" +
                "usuarioId=" + usuarioId +
                ", valoradoId=" + valoradoId +
                ", estrellas=" + estrellas +
                ", productId=" + productId +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
