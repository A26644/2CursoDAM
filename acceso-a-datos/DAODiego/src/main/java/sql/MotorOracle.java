package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MotorOracle implements IMotorSQL{
    private Connection conn;
    private ResultSet rs;
    private Statement st;
    private final String CONN_URL = "jdbc:postgresql://database-1.cpmqkeqmhomo.us-east-1.rds.amazonaws.com/JuguetesBD";
    private final String DB_NAME = "postgres";
    private final String DB_PASSWORD = "12344321";
    @Override
    public void connect() {

    }

    @Override
    public ResultSet executeQuery(String sql) {
        return null;
    }

    @Override
    public int executeUpdate(String sql) {
        return 0;
    }

    @Override
    public void disconnect() {

    }
}
