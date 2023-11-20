package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Usuario;
import model.UsuarioNumVentas;

public class UsuarioDAO {
    MotorPostgre motorPostgre = new MotorPostgre();
    private final String LOGIN = "SELECT U.USUARIO_ID FROM USUARIO U WHERE U.EMAIL = ? AND U.PASS = ?";
    private final String FIND = "SELECT * FROM USUARIO U WHERE U.USUARIO_ID = ?";
    private final String FINDMOST = "SELECT U.USUARIO_ID, U.NOMBRE, U.APELLIDO1, U.APELLIDO2, U.EMAIL, count(*) \r\n" + //
            "FROM USUARIO U \r\n" + //
            "INNER JOIN PRODUCTO P ON U.USUARIO_ID = P.USUARIOID\r\n" + //
            "GROUP BY U.USUARIO_ID \r\n" + //
            "ORDER BY COUNT(*) \r\n" + //
            "DESC LIMIT 10";

    public Usuario find(int userId) {
        Usuario usuario = new Usuario();
        try {
            motorPostgre.preparePreparedStatement(FIND);
            motorPostgre.getPpSt().setInt(1, userId);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("USUARIO_ID"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellido1(rs.getString("APELLIDO1"));
                usuario.setApellido2(rs.getString("APELLIDO2"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setPass(rs.getString("PASS"));
                usuario.setPhone(rs.getString("PHONE"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }

    public Usuario login(Usuario bean) {
        Usuario usuario = new Usuario();
        try {
            motorPostgre.preparePreparedStatement(LOGIN);
            motorPostgre.getPpSt().setString(1, bean.getEmail());
            motorPostgre.getPpSt().setString(2, bean.getPass());
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("USUARIO_ID"));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return usuario;

    }

    public ArrayList<UsuarioNumVentas> findMost() {
        ArrayList<UsuarioNumVentas> lstUsuario = new ArrayList<>();
        try {
            motorPostgre.preparePreparedStatement(FINDMOST);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                UsuarioNumVentas usuarioVenta = new UsuarioNumVentas();
                usuarioVenta.setId(rs.getInt("USUARIO_ID"));
                usuarioVenta.setNombre(rs.getString("NOMBRE"));
                usuarioVenta.setApellido1(rs.getString("APELLIDO1"));
                usuarioVenta.setApellido2(rs.getString("APELLIDO2"));
                usuarioVenta.setNumeroVentas(rs.getInt("COUNT"));
                usuarioVenta.setEmail(rs.getString("EMAIL"));
                lstUsuario.add(usuarioVenta);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstUsuario;

    }

}
