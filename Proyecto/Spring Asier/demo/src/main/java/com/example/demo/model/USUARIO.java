package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class USUARIO {

    @Id
    @Column(name = "usuario_ID")
    Long id;

    String USUARIO_NAME;

    public USUARIO() {
    }

    public USUARIO(Long usuario_ID, String uSUARIO_NAME) {
        id = usuario_ID;
        USUARIO_NAME = uSUARIO_NAME;
    }

    public Long getUSUARIO_ID() {
        return id;
    }

    public void setUSUARIO_ID(Long uSUARIO_ID) {
        id = uSUARIO_ID;
    }

    public String getUSUARIO_NAME() {
        return USUARIO_NAME;
    }

    public void setUSUARIO_NAME(String uSUARIO_NAME) {
        USUARIO_NAME = uSUARIO_NAME;
    }

}
