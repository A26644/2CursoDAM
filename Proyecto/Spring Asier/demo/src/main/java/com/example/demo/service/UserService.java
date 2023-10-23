package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.interfaces.IRepository;
import com.example.demo.interfaces.IService;
import com.example.demo.model.USUARIO;

@Service
public class UserService implements IService<UserDTO, Integer> {

    @Autowired
    IRepository repository;

    public List<USUARIO> gettAll() {

        return repository.findAll();

    }

    @Override
    public UserDTO getById(Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public UserDTO create(UserDTO bean) {

        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserDTO update(UserDTO bean) {

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");

    }

}
