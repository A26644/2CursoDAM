package com.example.myapplication.beans;

public class Valoracion {
    private Integer id;
    private Integer usuarioId;
    private Integer estrellas;
    private String comentario;
    private Integer usuarioValoradoId;

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

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Valoracion(int usuarioId, int estrellas, String comentario, int usuarioValoradoId) {
        this.usuarioId = usuarioId;
        this.estrellas = estrellas;
        this.comentario = comentario;
        this.usuarioValoradoId = usuarioValoradoId;
    }

    public Valoracion(int usuarioId, int estrellas, int usuarioValoradoId) {
        this.usuarioId = usuarioId;
        this.estrellas = estrellas;
        this.usuarioValoradoId = usuarioValoradoId;
    }

    public int getUsuarioValoradoId() {
        return usuarioValoradoId;
    }

    public void setUsuarioValoradoId(int usuarioValoradoId) {
        this.usuarioValoradoId = usuarioValoradoId;
    }

}
