package Dao;

import java.sql.*;


public class BaseDao {
    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement state = null;




    public void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean add(Connection conn,String sql, Object... obj) {
        boolean result = false;
        int temp = 1;
        try {
            state = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                state.setObject(temp, obj[i]);
                temp++;
            }
            int a = state.executeUpdate();
            result = a > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet search(Connection conn,String sql, Object... obj) {
        ResultSet rs = null;
        int temp = 1;
        try {
            state = conn.prepareStatement(sql);
           if (obj!=null) {
               for (int i = 0; i < obj.length; i++) {
                   state.setObject(temp, obj[i]);
                   temp++;
               }
           }
            rs = state.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }




    public int [] insertmore(Connection conn,String sql, Object[][] obj){
        PreparedStatement stat=null;
        int []x=null;
        try {
            stat=conn.prepareStatement(sql);
            for(int i=0;i<obj.length;i++){
                if(obj[i][0]!=null) {
                    for (int j = 0; j < obj[i].length; j++) {
                        if(obj[i][j]!=null){
                            stat.setObject(j+1,obj[i][j]);
                        }else{
                            break;
                        }
                    }
                    stat.addBatch();
                }else{
                    break;
                }
            }
            conn.setAutoCommit(false);
            x=stat.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("多条插入时有重复!");
            try {
                conn.rollback();
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return x;
    }
}
