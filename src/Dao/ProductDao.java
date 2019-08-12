package Dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ProductDao {
    public boolean delectduct(Connection conn, String sql, Object... obj);

    public boolean addduct(Connection conn,String sql, Object... obj);

    public boolean updateduct(Connection conn,String sql, Object... obj);

    public ResultSet findAll(Connection conn,String sql, Object... obj);

    public ResultSet count(Connection conn,String sql, Object... obj);

    public ResultSet checkRename(Connection conn,String sql, Object... obj);

    public int[] insertmore(Connection conn,String sql,Object[][] obj);
}
