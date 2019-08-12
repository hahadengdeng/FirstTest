package Dao;


import java.sql.Connection;
import java.sql.ResultSet;

public interface CategoryDao {
    public boolean delectcate(Connection conn, String sql, Object... obj);

    public boolean add(Connection conn,String sql, Object... obj);

    public boolean update(Connection conn,String sql, Object... obj);

    public ResultSet findAll(Connection conn,String sql, Object... obj);

    public ResultSet count(Connection conn,String sql, Object... obj);

    public ResultSet checkRename(Connection conn,String sql, Object... obj);

    public int[] insertmore(Connection conn,String sql, Object[][] obj);
}
