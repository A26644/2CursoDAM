package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Direccion;
import model.Producto;
import model.Usuario;
import model.Venta;

public class VentaDAO {
    MotorPostgre motorPostgre = new MotorPostgre();
    PreparedStatement statement;
    private final String FINDONSALE = "SELECT V.VENTA_ID, P.PRODUCTO_ID, P.MARCA, P.PRECIO, P.DESCRIPCION, P.NOMBRE, P.IMAGEN, P.ESTADO, P.COLOR FROM VENTA V INNER JOIN PRODUCTO P ON V.VENTA_PRODUCTOID = P.PRODUCTO_ID WHERE V.VENTA_VENDEDORID = ?";
    private final String ADD = "INSERT INTO public.venta \r\n" + //
            "(venta_compradorid, venta_vendedorid, venta_direccionid, venta_productoid, venta_vendido, venta_fecha)\r\n"
            + //
            "VALUES\r\n" + //
            "(?, ?, ?, ?, true, CURRENT_DATE)";
    private final String MODIFYADD = "UPDATE PRODUCTO P SET VENDIDO = TRUE WHERE P.PRODUCTO_ID = ?";
    private final String FIND = "SELECT V.VENTA_ID, V.VENTA_FECHA, V.VENTA_VENDEDORID, P.NOMBRE, P.PRODUCTO_ID, D.DIRECCION_DIRECCION, U.NOMBRE AS USUARIO_NOMBRE FROM VENTA V\r\n"
            + //
            "INNER JOIN PRODUCTO P ON V.VENTA_PRODUCTOID = P.PRODUCTO_ID\r\n" + //
            "INNER JOIN DIRECCION D ON V.VENTA_DIRECCIONID = D.DIRECCION_ID\r\n" + //
            "INNER JOIN USUARIO U ON V.VENTA_VENDEDORID = U.USUARIO_ID\r\n" + //
            "WHERE V.VENTA_COMPRADORID = ?";

    public Venta sell(Venta venta) {
        Venta ventaJson = new Venta();
        ventaJson.setVentaId(0);
        try {
            motorPostgre.preparePreparedStatement(ADD);
            motorPostgre.getPpSt().setInt(1, venta.getVendedor().getId());
            motorPostgre.getPpSt().setInt(2, venta.getComprador().getId());
            motorPostgre.getPpSt().setInt(3, venta.getDireccion().getId());
            motorPostgre.getPpSt().setInt(4, venta.getProducto().getId());
            Integer filasModificadas = motorPostgre.getPpSt().executeUpdate();
            motorPostgre.preparePreparedStatement(MODIFYADD);
            motorPostgre.getPpSt().setInt(1, venta.getProducto().getId());
            Integer filasModificadasModify = motorPostgre.getPpSt().executeUpdate();
            ventaJson.setVentaId(filasModificadas + filasModificadasModify);
        } catch (Exception e) {
            System.out.println(e);
        }
        return ventaJson;
    }

    public ArrayList<Venta> find(Integer userId) {
        ArrayList<Venta> lstVenta = new ArrayList<Venta>();
        try {
            motorPostgre.preparePreparedStatement(FIND);
            motorPostgre.getPpSt().setInt(1, userId);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setVentaId(rs.getInt("VENTA_ID"));
                Usuario vendedor = new Usuario(rs.getInt("VENTA_VENDEDORID"));
                vendedor.setNombre(rs.getString("USUARIO_NOMBRE"));
                venta.setVendedor(vendedor);
                venta.setDireccion(new Direccion(rs.getString("DIRECCION_DIRECCION")));
                Producto producto = new Producto(rs.getInt("PRODUCTO_ID"));
                producto.setNombre(rs.getString("NOMBRE"));
                venta.setProducto(producto);
                lstVenta.add(venta);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return lstVenta;
    }

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
