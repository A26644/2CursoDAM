package DAO;

import model.Albaran;
import sql.MotorPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbaranDAO implements IDAO<Albaran> {
    ArrayList<Albaran> lstAlbaran;
    MotorPostgres pg = new MotorPostgres();
    PreparedStatement PpSt;

    @Override
    public ArrayList<Albaran> find(int id) {
        try {
            lstAlbaran = new ArrayList<>();
            String sql = "SELECT * FROM ALBARAN WHERE ALBARAN_ID = " + id;
            ResultSet rs = pg.executeQuery(sql);
            while (rs.next()) {
                Albaran albaran = new Albaran();
                albaran.setAlbaranId(rs.getInt("ALBARAN_ID"));
                albaran.setAlbaranPedidoId(rs.getInt("ALBARAN_PEDIDIOID"));
                albaran.setAlbaranFecha(rs.getDate("ALBARAN_FECHA"));
                lstAlbaran.add(albaran);
            }
            return lstAlbaran;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return null;
        }
    }

    @Override
    public ArrayList<Albaran> findAll() {
        try {
            lstAlbaran = new ArrayList<>();
            String sql = "SELECT * FROM ALBARAN";
            ResultSet rs = pg.executeQuery(sql);
            while (rs.next()) {
                Albaran albaran = new Albaran();
                albaran.setAlbaranId(rs.getInt("ALBARAN_ID"));
                albaran.setAlbaranPedidoId(rs.getInt("ALBARAN_PEDIDOID"));
                albaran.setAlbaranFecha(rs.getDate("ALBARAN_FECHA"));
                lstAlbaran.add(albaran);
            }
            return lstAlbaran;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return null;
        }
    }

    @Override
    public int delete(int id) {
        try {
            String sql = "DELETE FROM ALBARAN WHERE ALBARAN_ID = " + id;
            return pg.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return 0;
        }
    }

    @Override
    public int update(Albaran bean) {
        try {
            pg.connect();
            String UPDATE = "UPDATE ALBARAN SET ALBARAN_PEDIDOID = ?, ALBARAN_FECHA = ? WHERE ALBARAN_ID = "
                    + bean.getAlbaranId();
            Connection conn = pg.getConn();
            PpSt = conn.prepareStatement(UPDATE);
            PpSt.setInt(1, bean.getAlbaranPedidoId());
            PpSt.setDate(2, bean.getAlbaranFecha());
            System.out.println(PpSt);
            PpSt.executeUpdate();
        } catch (SQLException e) {

            System.out.println("Error: " + e);
        }

        return 0;
    }
}
