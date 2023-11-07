package DAO;

import model.Empresa;
import sql.MotorPostgres;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaDAO implements IDAO<Empresa> {
    ArrayList<Empresa> lstEmpresa;
    MotorPostgres pg = new MotorPostgres();
    PreparedStatement PpSt;
    private final String FINDALL = "SELECT * FROM EMPRESA";
    private final String INSERT = "INSERT INTO EMPRESA (EMPRESA_NOMBRE, EMPRESA_CIF, EMPRESA_DIRECCIONPOSTAL, EMPRESA_DIRECCIONWEB, EMPRESA_TELEFONO) VALUES (?, ?, ?, ?, ?)";

    @Override
    public ArrayList<Empresa> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public ArrayList<Empresa> findAll() {
        try {
            pg.preparePreparedStatement(FINDALL);
            lstEmpresa = new ArrayList<>();
            ResultSet rs = pg.getPpSt().executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setEmpresaId(rs.getInt("EMPRESA_ID"));
                empresa.setEmpresaCif(rs.getString("EMPRESA_CIF"));
                empresa.setEmpresaDireccionPostal(rs.getString("EMPRESA_DIRECCIONPOSTAL"));
                empresa.setEmpresaDireccionWeb(rs.getString("EMPRESA_DIRECCIONWEB"));
                empresa.setEmpresaTelefono(rs.getString("EMPRESA_TELEFONO"));
                lstEmpresa.add(empresa);
            }
            return lstEmpresa;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            pg.disconnect();
        }
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int update(Empresa bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int add(Empresa bean) {
        try {
            pg.preparePreparedStatement(INSERT);
            pg.getPpSt().setString(1, bean.getEmpresaNombre());
            pg.getPpSt().setString(2, bean.getEmpresaCif());
            pg.getPpSt().setString(3, bean.getEmpresaDireccionPostal());
            pg.getPpSt().setString(4, bean.getEmpresaDireccionWeb());
            pg.getPpSt().setString(5, bean.getEmpresaTelefono());
            return pg.getPpSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            pg.disconnect();
        }
    }
}
