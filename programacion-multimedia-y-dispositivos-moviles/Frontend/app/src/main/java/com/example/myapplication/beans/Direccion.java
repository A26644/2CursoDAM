package com.example.myapplication.beans;

public class Direccion {
    private Integer id;
    private Usuario usuario;
    private String direccion;
    private Integer cp;
    private String ciudad;
    private String estado;
    private String pais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", direccion='" + direccion + '\'' +
                ", cp=" + cp +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
