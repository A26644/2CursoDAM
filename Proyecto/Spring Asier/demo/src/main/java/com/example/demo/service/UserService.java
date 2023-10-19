package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.UserDTO;
import com.example.demo.interfaces.IRepository;
import com.example.demo.interfaces.IService;

public class UserService implements IService<UserDTO, Integer> {

    @Autowired
    IRepository repository;

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

    public List<USUARIO> getAll() {
        return repository.findAll();

    }

}
