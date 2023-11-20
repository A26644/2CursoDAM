package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Producto;

public class ProductoDAO {
    MotorPostgre motorPostgre = new MotorPostgre();

    private final String FINDALL = "SELECT * FROM PRODUCTO";
    private final String ADD = "INSERT INTO PRODUCTO(usuarioid, marca, precio, fecha, descripcion, nombre, imagen, estado, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String FIND = "SELECT PRODUCTO_ID, MARCA, PRECIO, DESCRIPCION, NOMBRE, IMAGEN, ESTADO, COLOR FROM PRODUCTO WHERE USUARIOID = ?";

    public ArrayList<Producto> findAll() {
        ArrayList<Producto> lstProduct = new ArrayList<>();
        try {
            motorPostgre.preparePreparedStatement(FINDALL);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                int userId = rs.getInt("ID");
                producto.setId(userId);
                producto.setUsuario(new UsuarioDAO().find(userId));
                producto.setMarca(rs.getString("MARCA"));
                producto.setPrecio(rs.getDouble("PRECIO"));
                producto.setFecha(rs.getDate("FECHA"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setEstado(rs.getString("ESTADO"));
                producto.setColor(rs.getString("COLOR"));
                lstProduct.add(producto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstProduct;

    }

    public ArrayList<Producto> find(int userId) {
        ArrayList<Producto> lstProductos = new ArrayList<>();
        try {
            motorPostgre.preparePreparedStatement(FIND);
            motorPostgre.getPpSt().setInt(1, userId);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("PRODUCTO_ID"));
                producto.setMarca(rs.getString("MARCA"));
                producto.setPrecio(rs.getDouble("PRECIO"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setEstado(rs.getString("ESTADO"));
                producto.setColor(rs.getString("COLOR"));
                lstProductos.add(producto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstProductos;

    }

    public Producto add(Producto bean) {
        Integer filasModificadas = null;
        try {
            motorPostgre.preparePreparedStatement(ADD);
            motorPostgre.getPpSt().setInt(1, bean.getUsuario().getId());
            motorPostgre.getPpSt().setString(2, bean.getMarca());
            motorPostgre.getPpSt().setDouble(3, bean.getPrecio());
            motorPostgre.getPpSt().setDate(4, bean.getFecha());
            motorPostgre.getPpSt().setString(5, bean.getDescripcion());
            motorPostgre.getPpSt().setString(6, bean.getNombre());
            motorPostgre.getPpSt().setString(7, bean.getImagen());
            motorPostgre.getPpSt().setString(8, bean.getEstado());
            motorPostgre.getPpSt().setString(9, bean.getColor());
            filasModificadas = motorPostgre.getPpSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);

        }
        // MANDAR EN FORMATO OBJETO UN 1 O UN 0
        if (filasModificadas != null) {
            return new Producto(1);
        } else {
            return new Producto(0);
        }

    }

}
