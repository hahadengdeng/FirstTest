package Dao;


import java.sql.Connection;
import java.sql.ResultSet;

public class AdminDaoImpl extends BaseDao implements AdminDao {


    @Override
    public ResultSet findAll(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public ResultSet count(Connection conn,String sql, Object... obj) {//---------------------------------
        return super.search(conn,sql, obj);
    }

    @Override
    public ResultSet checkRename(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public ResultSet findcount(Connection conn, String sql, Object... obj) {
        return super.search(conn,sql,obj);
    }

    @Override
    public ResultSet login(Connection conn,String sql, Object... obj) {
        return super.search(conn,sql, obj);
    }

    @Override
    public boolean resigst(Connection conn,String sql, Object... obj) {
        return super.add(conn,sql, obj);
    }

}
