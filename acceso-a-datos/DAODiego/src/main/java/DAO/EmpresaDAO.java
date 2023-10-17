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
    String UPDATE = "UPDATE EMPRESA SET EMPRESA_NOMBRE = ?, EMPRESA_CIF = ?, EMPRESA_ DIRECCIONPOSTAL = ?, EMPRESA_DIRECCIONWEB = ?, EMPRESA_TELEFONO = ? WHERE EMPRESA_ID = ?";

    @Override
    public ArrayList<Empresa> find(int id) {
        try {
            lstEmpresa = new ArrayList<>();
            String sql = "SELECT * FROM EMPRESA WHERE EMPRESA_ID = " + id;
            ResultSet rs = pg.executeQuery(sql);
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setEmpresaId(rs.getInt("EMPRESA_ID"));
                empresa.setEmpresaCif(rs.getString("EMPRESA_CIF"));
                empresa.setEmpresaDireccionPostal(rs.getString("EMPRESA_DIRECCIONPOSTAL"));
                empresa.setEmpresaDireccionWeb(rs.getString("EMPRESA_DIRECCIONWEB"));
                empresa.setEmpresaTelefono(rs.getInt("EMPRESA_TELEFONO"));
                lstEmpresa.add(empresa);
            }
            return lstEmpresa;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<Empresa> findAll() {
        try {
            lstEmpresa = new ArrayList<>();
            String sql = "SELECT * FROM EMPRESA";
            ResultSet rs = pg.executeQuery(sql);
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setEmpresaId(rs.getInt("EMPRESA_ID"));
                empresa.setEmpresaCif(rs.getString("EMPRESA_CIF"));
                empresa.setEmpresaDireccionPostal(rs.getString("EMPRESA_DIRECCIONPOSTAL"));
                empresa.setEmpresaDireccionWeb(rs.getString("EMPRESA_DIRECCIONWEB"));
                empresa.setEmpresaTelefono(rs.getInt("EMPRESA_TELEFONO"));
                lstEmpresa.add(empresa);
            }
            return lstEmpresa;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int delete(int id) {
        try {
            String sql = "DELETE FROM EMPRESA WHERE ID = " + id;
            return pg.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

    @Override
    public int update(Empresa bean) {
        return 0;
    }
}
