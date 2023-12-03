package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import MotorSQL.MotorPostgre;
import model.Producto;
import model.Usuario;

public class ProductoDAO {
    MotorPostgre motorPostgre = new MotorPostgre();
    private final String IMAGEN1 = "http://10.0.2.2:8080/app/img/product/";
    private final String IMAGEN2 = ".jpg";
    private final String FINDALL = "SELECT P.*, U.NOMBRE AS NOMBRE_USUARIO \r\n" + //
            "FROM PRODUCTO\r\n" + //
            "P INNER JOIN USUARIO U\r\n" + //
            "ON P.USUARIOID = U.USUARIO_ID\r\n" + //
            "WHERE U.USUARIO_ID <> ? AND VENDIDO = FALSE";
    private final String ADD = "INSERT INTO PRODUCTO(usuarioid, marca, precio, fecha, descripcion, nombre, imagen, estado, color) VALUES (?, ?, ?, ?, ?, ?, 'imagen', ?, ?)";
    private final String FIND = "SELECT PRODUCTO_ID, MARCA, PRECIO, DESCRIPCION, NOMBRE, IMAGEN, ESTADO, COLOR FROM PRODUCTO WHERE USUARIOID = ?";

    private final String FINDFILTER = "SELECT P.*, U.NOMBRE AS NOMBRE_USUARIO FROM PRODUCTO P\r\n" + //
            "INNER JOIN CATEGORIAPRODUCTO CP ON  P.PRODUCTO_ID = CP.PRODUCTOID\r\n" + //
            "INNER JOIN USUARIO U ON P.USUARIOID = U.USUARIO_ID\r\n" + //
            "WHERE CP.CATEGORIAID IN ";

    public ArrayList<Producto> findFilter(String[] filterNumbers, Integer usuarioId) {
        ArrayList<Producto> lstProduct = new ArrayList<>();
        String[] filtrosArray = filterNumbers[0].split("\\.");
        System.out.println("Has separado este numero de numeros: " + filtrosArray.length);
        String base = "(";
        for (int i = 0; i < filtrosArray.length; i++) {
            if (i == filtrosArray.length - 1) {
                base += filtrosArray[i] + ") ";
            } else {
                base += filtrosArray[i] + ",";
            }
        }

        if (!filterNumbers[1].equalsIgnoreCase("")) {
            base += "AND UPPER(P.NOMBRE) LIKE UPPER('%" + filterNumbers[1] + "%')";
        }
        base += " AND USUARIOID <> " + usuarioId + " AND VENDIDO = FALSE GROUP BY PRODUCTO_ID, U.NOMBRE";
        System.out.println("Esta es la consulta: " + FINDFILTER + base);
        try {
            motorPostgre.preparePreparedStatement(FINDFILTER + base);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                System.out.println("Estoy añadiendo un producto");
                Producto producto = new Producto();
                Usuario usuario = new Usuario();
                // MONTAR AL USUARIO
                usuario.setId(rs.getInt("USUARIOID"));
                usuario.setNombre(rs.getString("NOMBRE_USUARIO"));
                producto.setUsuario(usuario);
                // MONTAR EL PRODUCTO
                producto.setId(rs.getInt("PRODUCTO_ID"));
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

    public ArrayList<Producto> findAll(Integer userId) {
        ArrayList<Producto> lstProduct = new ArrayList<>();
        try {
            motorPostgre.preparePreparedStatement(FINDALL);
            motorPostgre.getPpSt().setInt(1, userId);
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                Usuario usuario = new Usuario();
                // MONTAR AL USUARIO
                usuario.setId(rs.getInt("USUARIOID"));
                usuario.setNombre(rs.getString("NOMBRE_USUARIO"));
                producto.setUsuario(usuario);
                // MONTAR EL PRODUCTO
                producto.setId(rs.getInt("PRODUCTO_ID"));
                producto.setMarca(rs.getString("MARCA"));
                producto.setPrecio(rs.getDouble("PRECIO"));
                producto.setFecha(rs.getDate("FECHA"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setImagen(IMAGEN1 + rs.getString("IMAGEN") + IMAGEN2);
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
            motorPostgre.getPpSt().setString(7, bean.getEstado());
            motorPostgre.getPpSt().setString(8, bean.getColor());
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
