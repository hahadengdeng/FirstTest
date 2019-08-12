package Dao;

import java.sql.Connection;
import java.sql.ResultSet;

public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public boolean delectduct(Connection conn, String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public boolean addduct(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public boolean updateduct(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public ResultSet findAll(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public ResultSet count(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public ResultSet checkRename(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    public int[] insertmore(Connection conn,String sql, Object[][] obj) {
        return super.insertmore(conn,sql, obj);
    }
}
