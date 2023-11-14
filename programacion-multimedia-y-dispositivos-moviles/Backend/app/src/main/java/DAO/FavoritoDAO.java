package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Favorito;

public class FavoritoDAO implements IDAO<Favorito> {
    MotorPostgre motorPostgre = new MotorPostgre();
    PreparedStatement statement;
    private final String FINDALL = "SELECT * FROM FAVORITO";

    @Override
    public ArrayList<Favorito> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public ArrayList<Favorito> findAll() {
        try {
            motorPostgre.preparePreparedStatement(FINDALL);
            ArrayList<Favorito> lstFavorito = new ArrayList<>();
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Favorito favorito = new Favorito();
                favorito.setId(rs.getInt("ID"));
                favorito.setUsuarioId(rs.getInt("USUARIOID"));
                favorito.setProductoId(rs.getInt("PRODUCTOID"));
                lstFavorito.add(favorito);
            }
            return lstFavorito;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int update(Favorito bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int add(Favorito bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
