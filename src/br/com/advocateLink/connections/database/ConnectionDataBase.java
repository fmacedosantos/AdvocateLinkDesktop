package br.com.advocateLink.connections.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionDataBase {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/advocatelink";
    private final String USER= "root";
    private final String PASSWORD= "root";
    private Connection connection;
    public Connection connectionDB() throws SQLException {
       return connection = DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public void closeDB() throws SQLException{
        connection.close();
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
