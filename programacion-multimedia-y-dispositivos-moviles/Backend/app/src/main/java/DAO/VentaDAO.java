package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;

import model.Producto;

import model.Venta;

public class VentaDAO {
    MotorPostgre motorPostgre = new MotorPostgre();
    PreparedStatement statement;
    private final String FINDONSALE = "SELECT V.VENTA_ID, P.PRODUCTO_ID, P.MARCA, P.PRECIO, P.DESCRIPCION, P.NOMBRE, P.IMAGEN, P.ESTADO, P.COLOR FROM VENTA V INNER JOIN PRODUCTO P ON V.VENTA_PRODUCTOID = P.PRODUCTO_ID WHERE V.VENTA_VENDEDORID = ?";

    public ArrayList<Venta> findOnSale(int id) {

        ArrayList<Venta> lstVenta = new ArrayList<>();
        try {
            motorPostgre.preparePreparedStatement(FINDONSALE);
            motorPostgre.getPpSt().setInt(1, id);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                // RELLENAR VENTA
                venta.setVentaId(rs.getInt("VENTA_ID"));
                // RELLENAR PRODUCTO
                venta.setProducto(new Producto());
                venta.getProducto().setId(rs.getInt("PRODUCTO_ID"));
                venta.getProducto().setMarca(rs.getString("MARCA"));
                venta.getProducto().setPrecio(rs.getDouble("PRECIO"));
                venta.getProducto().setDescripcion(rs.getString("DESCRIPCION"));
                venta.getProducto().setNombre(rs.getString("NOMBRE"));
                venta.getProducto().setImagen(rs.getString("IMAGEN"));
                venta.getProducto().setEstado(rs.getString("ESTADO"));
                venta.getProducto().setColor(rs.getString("COLOR"));
                lstVenta.add(venta);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstVenta;
    }

}
