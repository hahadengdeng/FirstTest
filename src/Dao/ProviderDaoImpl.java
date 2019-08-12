package Dao;

import java.sql.Connection;
import java.sql.ResultSet;

public class ProviderDaoImpl extends BaseDao implements ProviderDao {
    @Override
    public ResultSet findAll(Connection conn, String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public ResultSet count(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public boolean addvider(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public boolean updatevider(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public ResultSet checkRename(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public boolean delectvider(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public int[] insertmore(Connection conn,String sql,Object[][] obj){return super.insertmore(conn,sql, obj);}
}
