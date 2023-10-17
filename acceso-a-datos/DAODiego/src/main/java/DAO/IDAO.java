package DAO;

import java.util.ArrayList;

public interface IDAO <I>{
    public ArrayList<I> find (int id);
    public ArrayList<I> findAll ();
    public int delete (int id);
    public int update(I bean);

}
