package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Usuario;

public class UsuarioDAO implements IDAO<Usuario> {
    MotorPostgre motorPostgre = new MotorPostgre();

    private final String FINDMOST = "SELECT U.ID, U.NOMBRE, COUNT(*) AS Ventas FROM VENTA V INNER JOIN USUARIO U ON V.USUARIOID = U.ID GROUP BY U.ID, U.NOMBRE ORDER BY COUNT(*) DESC LIMIT 10";

    @Override
    public ArrayList<Usuario> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public ArrayList<Usuario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public ArrayList<Usuario> findMost() {
        try {
            ArrayList<Usuario> lstUsuario = new ArrayList<>();
            motorPostgre.preparePreparedStatement(FINDMOST);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setVentas(rs.getInt("VENTAS"));
                lstUsuario.add(usuario);

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
