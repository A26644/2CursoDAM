package com.example.demo.interfaces;

public interface IService<X, ID> {
    public X getById(ID id);

    public X create(X bean);

    public X update(X bean);

    public void delete(ID id);

}
