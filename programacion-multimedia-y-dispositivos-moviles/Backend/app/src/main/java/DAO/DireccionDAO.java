package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Direccion;

public class DireccionDAO implements IDAO<Direccion> {
    MotorPostgre motorPostgre = new MotorPostgre();
    PreparedStatement statement;
    private final String FINDALL = "SELECT * FROM DIRECCION";

    @Override
    public ArrayList<Direccion> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList<Direccion> findAll() {

        try {
            motorPostgre.preparePreparedStatement(FINDALL);
            ArrayList<Direccion> lstDireccion = new ArrayList<>();
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("DIRECCION_ID"));
                direccion.setUsuarioId(rs.getInt("USUARIOID"));
                direccion.setDireccion(rs.getString("DIRECCION"));
                direccion.setCp(rs.getInt("CP"));
                direccion.setCiudad(rs.getString("CIUDAD"));
                direccion.setEstado(rs.getString("ESTADO"));
                direccion.setPais(rs.getString("PAIS"));
                lstDireccion.add(direccion);
            }
            return lstDireccion;
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
    public int update(Direccion bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int add(Direccion bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
