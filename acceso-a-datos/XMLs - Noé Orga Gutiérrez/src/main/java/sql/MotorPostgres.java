package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MotorPostgres implements IMotorSQL {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement PpSt;
    private final String CONN_URL = "jdbc:postgresql://database-1.cpmqkeqmhomo.us-east-1.rds.amazonaws.com/JuguetesBD";
    private final String DB_NAME = "postgres";
    private final String DB_PASSWORD = "12344321";

    @Override
    public void connect() {
        try {

            conn = DriverManager.getConnection(CONN_URL, DB_NAME, DB_PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Conectado correctamente a la BD");
        }
    }

    @Override
    public void disconnect() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
            if (!rs.isClosed()) {
                rs.close();
            }
            if (!PpSt.isClosed()) {
                PpSt.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Desconectado con exito");
        }

    }

    public PreparedStatement getPpSt() {
        return PpSt;
    }

    public void preparePreparedStatement(String consulta) {
        try {
            this.connect();
            PpSt = conn.prepareStatement(consulta);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
