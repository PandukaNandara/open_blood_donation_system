/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sliit.iblood.db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author niroth
 */
public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");

        File file = new File("resources/application.properties");
        FileReader fileReader = new FileReader(file);

        Properties properties = new Properties();
        properties.load(fileReader);

        String ip = properties.getProperty("ip");
        String port = properties.getProperty("port");
        String db = properties.getProperty("db");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        String jdbcUrl = "jdbc:mysql://" + ip + ":" + port + "/" + db + "?autoReconnect=true&useSSL=false";
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException, IOException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
