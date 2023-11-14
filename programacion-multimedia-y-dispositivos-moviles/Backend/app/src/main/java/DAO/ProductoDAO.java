package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MotorSQL.MotorPostgre;
import model.Producto;

public class ProductoDAO implements IDAO<Producto> {
    MotorPostgre motorPostgre = new MotorPostgre();
    PreparedStatement statement;
    private final String FINDALL = "SELECT * FROM PRODUCTO";

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
