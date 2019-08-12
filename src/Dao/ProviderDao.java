package Dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ProviderDao {
    public boolean delectvider(Connection conn, String sql, Object... obj);

    public boolean addvider(Connection conn,String sql, Object... obj);

    public boolean updatevider(Connection conn,String sql, Object... obj);

    public ResultSet findAll(Connection conn,String sql, Object... obj);

    public ResultSet count(Connection conn,String sql, Object... obj);

    public ResultSet checkRename(Connection conn,String sql, Object... obj);

    public int[] insertmore(Connection conn,String sql,Object[][] obj);
}
