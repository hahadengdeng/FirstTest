package Instrument;

import java.sql.*;

public class CheckDelect {
    public static boolean Checkcategorys(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean x = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "123456");
            String sql = "select * from products LEFT JOIN categorys  ON categorys.categoryID=products.categroyID    where  category_name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                x = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return x;
    }


    public static boolean Checkprivuder(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean x = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "123456");
            String sql = "select * from products LEFT JOIN providers  ON providers.providerID=products.providerID    where  provider_name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                x = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return x;
    }
}
