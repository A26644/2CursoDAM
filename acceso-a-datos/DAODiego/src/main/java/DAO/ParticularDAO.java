package DAO;

import model.Particular;
import sql.MotorPostgres;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ParticularDAO implements IDAO<Particular> {
    ArrayList<Particular> lstParticular;
    MotorPostgres pg = new MotorPostgres();
    private final String FINDALL = "SELECT * FROM PARTICULAR";
    private final String INSERT = "INSERT INTO PARTICULAR (PARTICULAR_NOMBRE, PARTICULAR_APELLIDO, PARTICULAR_TELEFONO, PARTICULAR_DIRECCION, PARTICULAR_FIRMA) VALUES (?, ?, ?, ?, ?)";

    @Override
    public ArrayList<Particular> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public ArrayList<Particular> findAll() {
        try {
            pg.preparePreparedStatement(FINDALL);
            lstParticular = new ArrayList<>();
            ResultSet rs = pg.getPpSt().executeQuery();
            while (rs.next()) {
                Particular particular = new Particular();
                particular.setParticularId(rs.getInt("PARTICULAR_ID"));
                particular.setParticularNombre(rs.getString("PARTICULAR_NOMBRE"));
                particular.setParticularApellido(rs.getString("PARTICULAR_APELLIDO"));
                particular.setParticularTelefono(rs.getString("PARTICULAR_TELEFONO"));
                particular.setParticularDireccion(rs.getString("PARTICULAR_DIRECCION"));
                lstParticular.add(particular);
            }
            return lstParticular;

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
    public int update(Particular bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int add(Particular bean) {
        try {
            pg.preparePreparedStatement(INSERT);
            pg.getPpSt().setString(1, bean.getParticularNombre());
            pg.getPpSt().setString(2, bean.getParticularApellido());
            pg.getPpSt().setString(3, bean.getParticularTelefono());
            pg.getPpSt().setString(4, bean.getParticularDireccion());
            pg.getPpSt().setString(5, bean.getFirma());
            return pg.getPpSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            pg.disconnect();
        }

    }
}
