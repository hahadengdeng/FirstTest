package Instrument;

import java.sql.*;

public class FindId {
    public static int findvider(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int x = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "123456");
            String sql = "select providerID from  providers  where  provider_name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                x = rs.getInt(1);
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

    public static int findcate(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int x = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "123456");
            String sql = "select categoryID from  categorys  where  category_name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                x = rs.getInt(1);
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

    public static int findduct(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int x = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "123456");
            String sql = "select productID from  products  where  product_name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                x = rs.getInt(1);
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

    public static boolean ductcate(int categoryID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean x = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "123456");
            String sql = "select * from  categorys  where  categoryID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryID);
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

    public static boolean ductvider(int categoryID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean x = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "123456");
            String sql = "select * from  providers  where  providerID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryID);
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
