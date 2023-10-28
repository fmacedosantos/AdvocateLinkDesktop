package br.com.advocateLink.connections.database.commands;

import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.interfaces.IDatabase;
import br.com.advocateLink.classes.models.Address;
import br.com.advocateLink.classes.models.Contact;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.connections.database.ConnectionDataBase;
import lombok.NonNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
public class CommandsEmployee extends ConnectionDataBase implements IDatabase<Employee> {
    private final String deletePerson = "DELETE FROM advocatelink.person WHERE id = ?;";
    private final String deleteAddress = "DELETE FROM advocatelink.address WHERE id_person = ?;";
    private final String deleteContact = "DELETE FROM advocatelink.contact WHERE id = ?;";
    private final String selectQueryUser = "SELECT * FROM advocatelink.person WHERE id = ?;";
    private final String selectQueryAddress = "SELECT * FROM advocatelink.address WHERE id_person = ?;";
    private final String selectQueryContact = "SELECT * FROM advocatelink.contact WHERE id_person = ?;";
    private final String updateUser = "UPDATE advocatelink.person SET urlphoto = ?,salary = ?,role = ? WHERE id = ? ;";
    private final String updateContact = "UPDATE advocatelink.contact SET telephone = ?,email = ? WHERE id_person = ? ;";
    private final String insertPerson = "INSERT INTO advocatelink.person(name,cpf,urlphoto,salary,role) VALUE (?,?,?,?,?);";
    private final String insertAddress = "INSERT INTO advocatelink.address(rua,number,bairro,id_person) VALUE (?,?,?,?);";
    private final String insertContact = "INSERT INTO advocatelink.contact(telephone,email,id_person) VALUE (?,?,?);";
    private PreparedStatement PREPARED_STATEMENT;
    @Override
    public Boolean deleteRow(Employee employee) throws SQLException {
        PREPARED_STATEMENT = super.connectionDB().prepareStatement(deleteAddress);
        PREPARED_STATEMENT.setLong(1, employee.getId());
        PREPARED_STATEMENT.executeUpdate();
        PREPARED_STATEMENT = super.getConnection().prepareStatement(deleteContact);
        PREPARED_STATEMENT.setLong(1, employee.getId());
        PREPARED_STATEMENT.executeUpdate();
        PREPARED_STATEMENT = super.getConnection().prepareStatement(deletePerson);
        PREPARED_STATEMENT.setLong(1, employee.getId());
        PREPARED_STATEMENT.executeUpdate();
        super.closeDB();
        return true;
    }

    @Override
    public @NonNull Employee searchRow(Long id) throws SQLException, UserNotFound {
        PreparedStatement userStatement = super.connectionDB().prepareStatement(selectQueryUser);
        userStatement.setLong(1, id);
        ResultSet resultUser = userStatement.executeQuery();
        PreparedStatement addressStatement = super.getConnection().prepareStatement(selectQueryAddress);
        addressStatement.setLong(1, id);
        ResultSet resultAddress = addressStatement.executeQuery();
        PreparedStatement contactStatement = super.getConnection().prepareStatement(selectQueryContact);
        contactStatement.setLong(1, id);
        ResultSet resultContact = contactStatement.executeQuery();
        Employee employee;
        if (resultUser.next() && resultAddress.next() && resultContact.next()) {
            employee = new Employee(
                    resultUser.getInt("id"),
                    resultUser.getString("name"),
                    resultUser.getString("cpf"),
                    new Address(resultAddress.getString("rua"), resultAddress.getInt("number"), resultAddress.getString("bairro")),
                    new Contact(resultContact.getLong("telephone"), resultContact.getString("email")),
                    resultUser.getString("urlphoto"),
                    0,
                    resultUser.getString("role"),
                    resultUser.getDouble("salary")
            );
            super.closeDB();
            return employee;
        } else {
            super.closeDB();
            throw new UserNotFound("Usuário não existente");
        }
    }
    @Override
    public @NonNull Boolean updateRow(Long id, Employee temp) throws UserNotFound, SQLException {
        Optional.ofNullable(searchRow(id)).orElseThrow(()-> new UserNotFound("Usuario nao encontrado"));
        PreparedStatement userStatement = super.connectionDB().prepareStatement(updateUser);
        userStatement.setString(1, temp.getUrlfoto());
        userStatement.setDouble(2, temp.getSalary());
        userStatement.setString(3, temp.getRole());
        userStatement.setLong(4, id);
        userStatement.executeUpdate();
        PreparedStatement contactStatement = super.getConnection().prepareStatement(updateContact);
        contactStatement.setLong(1, temp.getContato().getTelefone());
        contactStatement.setString(2, temp.getContato().getEmail());
        contactStatement.setLong(3, id);
        contactStatement.executeUpdate();
        return true;
    }
    @Override
    public @NonNull Boolean insertRow(Employee employee) throws SQLException {
        PREPARED_STATEMENT = super.connectionDB().prepareStatement(insertPerson,Statement.RETURN_GENERATED_KEYS);
        PREPARED_STATEMENT.setString(1,employee.getNome());
        PREPARED_STATEMENT.setString(2,employee.getCpf());
        PREPARED_STATEMENT.setString(3,employee.getUrlfoto());
        PREPARED_STATEMENT.setDouble(4,employee.getSalary());
        PREPARED_STATEMENT.setString(5,employee.getRole());
        PREPARED_STATEMENT.executeUpdate();
        ResultSet generatedKeys = PREPARED_STATEMENT.getGeneratedKeys();
        Long key = -1l;
        if (generatedKeys.next()) {
            key = generatedKeys.getLong(1);
            PREPARED_STATEMENT = super.getConnection().prepareStatement(insertAddress);
            PREPARED_STATEMENT.setString(1, employee.getEndereco().getRua());
            PREPARED_STATEMENT.setInt(2, employee.getEndereco().getNumero());
            PREPARED_STATEMENT.setString(3, employee.getEndereco().getBairro());
            PREPARED_STATEMENT.setLong(4,key);
            PREPARED_STATEMENT.execute();
            PREPARED_STATEMENT = super.getConnection().prepareStatement(insertContact);
            PREPARED_STATEMENT.setLong(1, employee.getContato().getTelefone());
            PREPARED_STATEMENT.setString(2, employee.getContato().getEmail());
            PREPARED_STATEMENT.setLong(3,key);
            PREPARED_STATEMENT.execute();
        }
        super.closeDB();
        return true;
    }
}
