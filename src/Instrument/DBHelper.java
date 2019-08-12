package Instrument;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBHelper {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        ResourceBundle bundle=ResourceBundle.getBundle("db");
        url=bundle.getString("jdbc.url");
        user=bundle.getString("jdbc.user");
        password=bundle.getString("jdbc.password");
        driver=bundle.getString("jdbc.driver");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            Connection conn= DriverManager.getConnection(url,user,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
