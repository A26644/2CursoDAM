package DAO;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Cliente;
import model.ClienteAlbaran;
import sql.MotorPostgres;

public class ClienteAlbaranDAO implements IDAO<ClienteAlbaran> {
    ArrayList<ClienteAlbaran> lstClienteAlbaran;
    MotorPostgres pg = new MotorPostgres();
    PreparedStatement PpSt;
    String UPDATE = "UPDATE EMPRESA SET EMPRESA_NOMBRE = ?, EMPRESA_CIF = ?, EMPRESA_ DIRECCIONPOSTAL = ?, EMPRESA_DIRECCIONWEB = ?, EMPRESA_TELEFONO = ? WHERE EMPRESA_ID = ?";

    @Override
    public ArrayList<ClienteAlbaran> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public ArrayList<ClienteAlbaran> findAll() {

    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int update(ClienteAlbaran bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
