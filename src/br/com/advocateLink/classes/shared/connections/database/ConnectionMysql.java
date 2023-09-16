package br.com.advocateLink.classes.shared.connections.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    //connectar no banco de dados no 2 SPRINT...
    public Connection ConnectDatabase(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/advocatelink?user=root&password=root");
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
