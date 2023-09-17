package br.com.advocateLink.classes.shared.connections.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class will be responsible for the services of the connections in the database, having commands to change, delete and add data.
 * @version 1.0
 * @author Guilherme vinicius
 */
public class ConnectionMysqlUtil {
    //connectar no banco de dados no 2 SPRINT...
    //connectar no banco de dados no 2 SPRINT...
    //connectar no banco de dados no 2 SPRINT...
    //connectar no banco de dados no 2 SPRINT...
    //connectar no banco de dados no 2 SPRINT...
    //connectar no banco de dados no 2 SPRINT...
    private final String insertUrl="INSERT INTO advocatelink.users(nome,cpf,addressKey,contactKey,urlfoto,salary,role) VALUE (?,?,?,?,?,?,?);";
    private Connection connection;
    private PreparedStatement preparedStatement;

    /**
     * This method will have the function of initiating the database connection
     * @return
     */
    public Connection ConnectDatabase(){
        try {
            return  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advocatelink?user=root&password=root");
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    /**
     * This method deletes an object from the database from the parameters.
     * @param nameTable
     * @param nameRow
     * @param nameObject
     * @return
     * @throws SQLException
     */
    public boolean deleteRow(String nameTable, String nameRow, String nameObject) throws SQLException {
        final String deleteUrl="DELETE FROM "+nameTable+" WHERE "+nameRow+" = ?;";
        try {
            preparedStatement =connection.prepareStatement(deleteUrl);
            preparedStatement.setString(1,nameObject);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }finally {
            connection.close();
        }
    }

    /**
     * This method changes a database object from the parameters.
     * @param nameTable
     * @param valueUpdate
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean updateRowUsers(String nameTable,String valueUpdate, int id) throws SQLException {
        final String updateUrl="UPDATE "+nameTable+" SET "+valueUpdate+" WHERE id = "+id+";";
        try {
            preparedStatement = connection.prepareStatement(updateUrl);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
        return false;
    }

    /**
     *  This method inserts an object into a row of the database from the parameters
     * @param name
     * @param cpf
     * @param adressKey
     * @param contactKey
     * @param urlfoto
     * @param salary
     * @param role
     * @return
     * @throws SQLException
     */
    public boolean insertRowUsers(String name, String cpf,int adressKey,int contactKey,String urlfoto,double salary,String role) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(insertUrl);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,cpf);
            preparedStatement.setInt(3,adressKey);
            preparedStatement.setInt(4,contactKey);
            preparedStatement.setString(5,urlfoto);
            preparedStatement.setDouble(6,salary);
            preparedStatement.setString(7,role);
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            return false;
        }finally {
            connection.close();
        }
    }
}
