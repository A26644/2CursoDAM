package DAO;

import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Valoracion;

public class ValoracionDAO implements IDAO<Valoracion> {
    private MotorPostgre motorPostgre = new MotorPostgre();
    private final String ADD = "INSERT INTO VALORACION(USUARIOID, ESTRELLAS, COMENTARIO, USUARIOVALORADOID) VALUES (?, ?, ?, ?)";

    @Override
    public ArrayList<Valoracion> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public ArrayList<Valoracion> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int update(Valoracion bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int add(Valoracion bean) {
        try {
            motorPostgre.preparePreparedStatement(ADD);
            motorPostgre.getPpSt().setInt(1, bean.getUsuarioId());
            motorPostgre.getPpSt().setInt(2, bean.getEstrellas());
            motorPostgre.getPpSt().setString(3, bean.getComentario());
            motorPostgre.getPpSt().setInt(4, bean.getUsuarioValoradoId());
            return motorPostgre.getPpSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

}
