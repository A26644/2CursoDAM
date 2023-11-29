package DAO;

import MotorSQL.MotorPostgre;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.Direccion;
import model.Usuario;

public class DireccionDAO {
    private final String FIND = "SELECT * FROM DIRECCION WHERE DIRECCION_USUARIOID = ?";
    MotorPostgre motorPostgre = new MotorPostgre();

    public ArrayList<Direccion> find(Integer userId) {
        ArrayList<Direccion> lstDireccion = new ArrayList<>();
        try {
            motorPostgre.preparePreparedStatement(FIND);
            motorPostgre.getPpSt().setInt(1, userId);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("DIRECCION_USUARIOID"));
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("DIRECCION_ID"));
                direccion.setUsuario(usuario);
                direccion.setDireccion(rs.getString("DIRECCION_DIRECCION"));
                direccion.setCp(rs.getInt("DIRECCION_CP"));
                direccion.setCiudad(rs.getString("DIRECCION_CIUDAD"));
                direccion.setEstado(rs.getString("DIRECCION_ESTADO"));
                direccion.setPais(rs.getString("DIRECCION_PAIS"));
                lstDireccion.add(direccion);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstDireccion;

    }

}
