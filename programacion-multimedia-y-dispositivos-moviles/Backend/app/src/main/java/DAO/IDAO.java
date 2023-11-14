package DAO;

import java.util.ArrayList;

public interface IDAO<E> {
    public ArrayList<E> find(int id);

    public ArrayList<E> findAll();

    public int delete(int id);

    public int update(E bean);

    public int add(E bean);

}
