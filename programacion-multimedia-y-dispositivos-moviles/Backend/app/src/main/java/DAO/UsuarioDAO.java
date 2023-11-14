package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Usuario;
import model.modelSon.UsuarioVenta;

public class UsuarioDAO implements IDAO<Usuario> {
    MotorPostgre motorPostgre = new MotorPostgre();
    private final String LOGIN = "SELECT * FROM USUARIO WHERE EMAIL = ? AND PASS = ?";

    private final String FINDMOST = "SELECT U.ID, U.NOMBRE, COUNT(*) AS Ventas FROM VENTA V INNER JOIN USUARIO U ON V.USUARIOID = U.ID GROUP BY U.ID, U.NOMBRE ORDER BY COUNT(*) DESC LIMIT 10";

    @Override
    public ArrayList<Usuario> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    public ArrayList<Usuario> login(Usuario bean) {
        try {
            ArrayList<Usuario> lstUsuario = new ArrayList<>();
            motorPostgre.preparePreparedStatement(LOGIN);
            motorPostgre.getPpSt().setString(1, bean.getEmail());
            motorPostgre.getPpSt().setString(2, bean.getPass());
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setPass(rs.getString("PASS"));
                lstUsuario.add(usuario);
            }
            return lstUsuario;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public ArrayList<Usuario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public ArrayList<UsuarioVenta> findMost() {
        try {
            ArrayList<UsuarioVenta> lstUsuario = new ArrayList<>();
            motorPostgre.preparePreparedStatement(FINDMOST);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                UsuarioVenta usuarioVenta = new UsuarioVenta();
                usuarioVenta.setId(rs.getInt("ID"));
                usuarioVenta.setNombre(rs.getString("NOMBRE"));
                usuarioVenta.setNumeroVentas(rs.getInt("VENTAS"));
                lstUsuario.add(usuarioVenta);

            }
            return lstUsuario;

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
    public int update(Usuario bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int add(Usuario bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
