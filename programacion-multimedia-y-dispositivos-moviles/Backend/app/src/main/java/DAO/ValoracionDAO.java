package DAO;

import MotorSQL.MotorPostgre;
import model.Valoracion;

public class ValoracionDAO {
    MotorPostgre motorPostgre = new MotorPostgre();
    private final String ADD = "INSERT INTO public.valoracion(\r\n" + //
            "\tusuarioid, estrellas, comentario, usuariovaloradoid, productoid)\r\n" + //
            "\tVALUES (?, ?, ?, ?, ?)";

    public Valoracion add(Valoracion valoracion) {
        Valoracion valoracionJson = new Valoracion();
        valoracionJson.setId(0);
        try {
            motorPostgre.preparePreparedStatement(ADD);
            motorPostgre.getPpSt().setInt(1, valoracion.getUsuario().getId());
            motorPostgre.getPpSt().setInt(2, valoracion.getEstrellas());
            motorPostgre.getPpSt().setString(3, valoracion.getComentario());
            motorPostgre.getPpSt().setInt(4, valoracion.getUsuarioValorado().getId());
            motorPostgre.getPpSt().setInt(5, valoracion.getProducto().getId());
            int filasModificadas = motorPostgre.getPpSt().executeUpdate();
            valoracionJson.setId(filasModificadas);
        } catch (Exception e) {
            System.out.println(e);
        }
        return valoracionJson;

    }

}
