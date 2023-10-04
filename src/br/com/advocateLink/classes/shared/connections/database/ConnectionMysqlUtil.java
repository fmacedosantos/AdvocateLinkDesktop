package br.com.advocateLink.classes.shared.connections.database;

import br.com.advocateLink.classes.models.Manageable;

import java.sql.*;

/**
 * This class will be responsible for the services of the connections in the database, having commands to change, delete and add data.
 * @version 1.0
 * @author Guilherme vinicius
 */
public class ConnectionMysqlUtil {
    private final String insertUrl="INSERT INTO advocatelink.person(name,cpf,urlphoto,salary,role,oab) VALUE (?,?,?,?,?,?);";
    private final String addressSql = "INSERT INTO advocatelink.address (rua, number, bairro, id_person) VALUES (?, ?, ?, LAST_INSERT_ID());";
    private final String contactSql = "INSERT INTO advocatelink.contact (telephone, email, id_person) VALUES (?, ?, LAST_INSERT_ID())";
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
     * @param manageable
     * @param oab
     * @param salary
     * @param role
     * @return
     * @throws SQLException
     */
    public boolean insertRowUsers(Manageable manageable, Double salary,String role,String oab) throws SQLException {
        try {
            PreparedStatement personStatement = connection.prepareStatement(insertUrl, Statement.RETURN_GENERATED_KEYS);
            personStatement.setString(1, manageable.getNome());
            personStatement.setString(2, manageable.getCpf());
            personStatement.setString(3, manageable.getUrlfoto());
            personStatement.setDouble(4, salary);
            personStatement.setString(5, role);
            personStatement.setString(6, oab);
            personStatement.executeUpdate();
            ResultSet generatedKeys = personStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                PreparedStatement addressStatement = connection.prepareStatement(addressSql);
                addressStatement.setString(1, manageable.getEndereco().getRua());
                addressStatement.setInt(2, manageable.getEndereco().getNumero());
                addressStatement.setString(3, manageable.getEndereco().getBairro());
                addressStatement.executeUpdate();
                PreparedStatement contactStatement = connection.prepareStatement(contactSql);
                contactStatement.setLong(1, manageable.getContato().getTelefone());
                contactStatement.setString(2, manageable.getContato().getEmail());
                contactStatement.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            connection.close();
        }
    }
}
