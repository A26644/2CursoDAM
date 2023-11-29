package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Categoria;

public class CategoriaDAO {
    MotorPostgre motorPostgre = new MotorPostgre();
    private final String FINDALL = "SELECT * FROM CATEGORIA C";

    public ArrayList<Categoria> findAll() {
        ArrayList<Categoria> lstCategoria = new ArrayList<>();
        try {
            motorPostgre.preparePreparedStatement(FINDALL);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setCategoriaId(rs.getInt("ID"));
                categoria.setCategoriaNombre(rs.getString("NOMBRE"));
                lstCategoria.add(categoria);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstCategoria;
    }

}
