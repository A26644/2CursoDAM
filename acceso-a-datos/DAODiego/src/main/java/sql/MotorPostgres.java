package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MotorPostgres implements IMotorSQL {

    private Connection conn;
    private ResultSet rs;
    private Statement st;
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
            System.out.println("Conectado correctamente");
        }
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try {
            this.connect();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        } finally {
            this.disconnect();
        }
    }

    @Override
    public int executeUpdate(String sql) {
        try {
            this.connect();
            st = conn.createStatement();
            int modifiedFiles = st.executeUpdate(sql);
            return modifiedFiles;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return 0;
        } finally {
            this.disconnect();
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
            if (!st.isClosed()) {
                st.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Desconectado con exito");
        }

    }

    public Connection getConn() {
        return conn;
    }

}
