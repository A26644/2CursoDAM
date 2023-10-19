package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.USUARIO;

public interface IRepository<T, ID> extends JpaRepository<USUARIO, Long> {

}
