package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.USUARIO;

public interface Repo extends JpaRepository<USUARIO, Long> {

}
