package br.com.advocateLink.classes.shared.connections.database;

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
}
