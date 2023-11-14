package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Producto;

public class ProductoDAO implements IDAO<Producto> {
    MotorPostgre motorPostgre = new MotorPostgre();

    private final String FINDALL = "SELECT * FROM PRODUCTO";
    private final String ADD = "INSERT INTO PRODUCTO(USUARIOID, MARCA, PRECIO, FECHA, DESCRIPCION, NOMBRE, IMAGEN, ESTADO, COLOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public ArrayList<Producto> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public ArrayList<Producto> findAll() {
        try {
            motorPostgre.preparePreparedStatement(FINDALL);
            ArrayList<Producto> lstProduct = new ArrayList<>();
            ResultSet rs = motorPostgre.getPpSt().executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("ID"));
                producto.setUsuarioId(rs.getInt("USUARIOID"));
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
            return lstProduct;
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
    public int update(Producto bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int add(Producto bean) {
        try {
            motorPostgre.preparePreparedStatement(ADD);
            motorPostgre.getPpSt().setInt(1, bean.getUsuarioId());
            motorPostgre.getPpSt().setString(2, bean.getMarca());
            motorPostgre.getPpSt().setDouble(3, bean.getPrecio());
            motorPostgre.getPpSt().setDate(4, bean.getFecha());
            motorPostgre.getPpSt().setString(5, bean.getDescripcion());
            motorPostgre.getPpSt().setString(6, bean.getNombre());
            motorPostgre.getPpSt().setString(7, bean.getImagen());
            motorPostgre.getPpSt().setString(8, bean.getEstado());
            motorPostgre.getPpSt().setString(9, bean.getColor());
            return motorPostgre.getPpSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

}
