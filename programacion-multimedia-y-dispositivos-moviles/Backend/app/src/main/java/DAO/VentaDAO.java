package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Venta;

public class VentaDAO implements IDAO<Venta> {
    MotorPostgre motorPostgre = new MotorPostgre();
    PreparedStatement statement;
    private final String FINDALL = "SELECT * FROM VENTA";
    private final String FIND = "SELECT * FROM VENTA WHERE USUARIOID = ?";

    @Override
    public ArrayList<Venta> find(int id) {
        try {
            motorPostgre.preparePreparedStatement(FIND);
            motorPostgre.getPpSt().setInt(1, id);
            ArrayList<Venta> lstVenta = new ArrayList<>();
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("ID"));
                venta.setUsuarioId(rs.getInt("USUARIOID"));
                venta.setDireccionId(rs.getInt("DIRECCIONID"));
                venta.setFecha(rs.getDate("FECHA"));
                lstVenta.add(venta);
            }
            return lstVenta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<Venta> findAll() {
        try {
            motorPostgre.preparePreparedStatement(FINDALL);
            ArrayList<Venta> lstVenta = new ArrayList<>();
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("ID"));
                venta.setUsuarioId(rs.getInt("USUARIOID"));
                venta.setDireccionId(rs.getInt("DIRECCIONID"));
                venta.setFecha(rs.getDate("FECHA"));
                lstVenta.add(venta);
            }
            return lstVenta;
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
    public int update(Venta bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int add(Venta bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
