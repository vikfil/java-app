package datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class JDBCSingleton {
    private static JDBCSingleton jdbc;
    private JDBCSingleton(){}

    public static JDBCSingleton getInstance() {
        if (jdbc == null) {
            jdbc = new JDBCSingleton();
        }
        return jdbc;
    }

    public static Connection getConnection() throws SQLException {

        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("url");
        String userName = resource.getString("user");
        String userPassword = resource.getString("password");

        return DriverManager.getConnection(url, userName, userPassword);
    }
}













