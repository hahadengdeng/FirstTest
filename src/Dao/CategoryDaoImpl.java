package Dao;

import java.sql.Connection;
import java.sql.ResultSet;


public class CategoryDaoImpl extends BaseDao implements CategoryDao {

    @Override
    public ResultSet findAll(Connection conn, String sql, Object... obj) {
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

    @Override
    public boolean update(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public boolean add(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public boolean delectcate(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

    @Override
    public int[] insertmore(Connection conn,String sql, Object[][] obj) {
        return super.insertmore(conn,sql, obj);
    }
}
