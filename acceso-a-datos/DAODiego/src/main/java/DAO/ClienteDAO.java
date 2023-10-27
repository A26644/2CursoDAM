package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cliente;

import sql.MotorPostgres;

public class ClienteDAO implements IDAO<Cliente> {
    ArrayList<Cliente> lstCliente;
    MotorPostgres pg = new MotorPostgres();
    PreparedStatement PpSt;
    String UPDATE = "UPDATE EMPRESA SET EMPRESA_NOMBRE = ?, EMPRESA_CIF = ?, EMPRESA_ DIRECCIONPOSTAL = ?, EMPRESA_DIRECCIONWEB = ?, EMPRESA_TELEFONO = ? WHERE EMPRESA_ID = ?";

    @Override
    public ArrayList<Cliente> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public ArrayList<Cliente> findAll() {
        try {
            lstCliente = new ArrayList<>();
            String sql = "SELECT * FROM EMPRESA";
            ResultSet rs = pg.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getInt("CLIENTE_ID"));
                cliente.setCIF(rs.getString("CLIENTE_CIF"));
                cliente.setEmail(rs.getString("CLIENTE_EMAIL"));
                cliente.setTelefono(rs.getInt("CLIENTE_TELEFONO"));
                cliente.setNombre(rs.getString("CLIENTE_NOMBRE"));
                cliente.setApellido(rs.getString("CLIENTE_APELLIDO"));
                lstCliente.add(cliente);
            }
            return lstCliente;

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
    public int update(Cliente bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
