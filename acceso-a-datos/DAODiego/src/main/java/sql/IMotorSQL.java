package sql;

import java.sql.ResultSet;

public interface IMotorSQL {
    public void connect();
    public ResultSet executeQuery(String sql);
    public int executeUpdate(String sql);
    public void disconnect();

}
