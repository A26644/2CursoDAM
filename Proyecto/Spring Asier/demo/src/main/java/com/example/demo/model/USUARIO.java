package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class USUARIO {

    @Id
    Long USUARIO_ID;
    String USUARIO_NAME;

    public USUARIO() {
    }

    public USUARIO(Long uSUARIO_ID, String uSUARIO_NAME) {
        USUARIO_ID = uSUARIO_ID;
        USUARIO_NAME = uSUARIO_NAME;
    }

    public Long getUSUARIO_ID() {
        return USUARIO_ID;
    }

    public void setUSUARIO_ID(Long uSUARIO_ID) {
        USUARIO_ID = uSUARIO_ID;
    }

    public String getUSUARIO_NAME() {
        return USUARIO_NAME;
    }

    public void setUSUARIO_NAME(String uSUARIO_NAME) {
        USUARIO_NAME = uSUARIO_NAME;
    }

}
