package Dao;


import java.sql.Connection;
import java.sql.ResultSet;

public interface AdminDao {
    public ResultSet login(Connection conn, String sql, Object... obj);

    public boolean resigst(Connection conn,String sql, Object... obj);

    public ResultSet findAll(Connection conn,String sql, Object... obj);

    public ResultSet count(Connection conn,String sql, Object... obj);

    public ResultSet checkRename(Connection conn,String sql, Object... obj);

    public ResultSet findcount(Connection conn,String sql,Object...obj);
}
