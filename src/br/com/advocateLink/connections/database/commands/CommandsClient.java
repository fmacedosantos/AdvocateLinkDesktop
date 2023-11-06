package br.com.advocateLink.connections.database.commands;

import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.interfaces.IDatabase;
import br.com.advocateLink.classes.models.Address;
import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.models.Contact;
import br.com.advocateLink.connections.database.ConnectionDataBase;
import lombok.NonNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class CommandsClient extends ConnectionDataBase implements IDatabase<Client> {
    private final String deletePerson = "DELETE FROM advocatelink.Manageable WHERE id = ?;";
    private final String deleteAddress = "DELETE FROM advocatelink.address WHERE id_Manageable = ?;";
    private final String deleteContact = "DELETE FROM advocatelink.contact WHERE id = ?;";
    private final String selectQueryUser = "SELECT * FROM advocatelink.Manageable WHERE id = ?;";
    private final String selectQueryAddress = "SELECT * FROM advocatelink.address WHERE id_Manageable = ?;";
    private final String selectQueryContact = "SELECT * FROM advocatelink.contact WHERE id_Manageable = ?;";
    private final String updateUser = "UPDATE advocatelink.Manageable SET urlphoto = ?,oab = ?,role = ? WHERE id = ? ;";
    private final String updateContact = "UPDATE advocatelink.contact SET telephone = ?,email = ? WHERE id_Manageable = ? ;";
    private final String updateAddress = "UPDATE advocatelink.address SET rua = ?,number = ?, bairro= ? WHERE id_Manageable = ? ;";
    private final String insertPerson = "INSERT INTO advocatelink.Manageable(name,cpf,urlphoto,oab,role) VALUE (?,?,?,?,?);";
    private final String insertAddress = "INSERT INTO advocatelink.address(rua,number,bairro,id_Manageable) VALUE (?,?,?,?);";
    private final String insertContact = "INSERT INTO advocatelink.contact(telephone,email,id_Manageable) VALUE (?,?,?);";
    private PreparedStatement PREPARED_STATEMENT;

    @Override
    public @NonNull Boolean updateRow(Long id, Client temp) throws UserNotFound, SQLException {
        Optional.ofNullable(searchRow(id)).orElseThrow(() -> new UserNotFound("Usuario nao encontrado"));
        PreparedStatement userStatement = super.connectionDB().prepareStatement(updateUser);
        userStatement.setString(1, temp.getUrlfoto());
        userStatement.setString(2, temp.getOab());
        userStatement.setString(3, temp.getAreaAtuacao());
        userStatement.setLong(4, id);
        userStatement.execute();
        PreparedStatement contactStatement = super.getConnection().prepareStatement(updateContact);
        contactStatement.setLong(1, temp.getContato().getTelefone());
        contactStatement.setString(2, temp.getContato().getEmail());
        contactStatement.setLong(3, id);
        contactStatement.execute();
        return true;
    }

    @Override
    public Boolean deleteRow(Client clients) throws SQLException, UserNotFound {
        this.searchRow(clients.getId());
        PREPARED_STATEMENT = super.connectionDB().prepareStatement(deleteAddress);
        PREPARED_STATEMENT.setLong(1, clients.getId());
        PREPARED_STATEMENT.executeUpdate();
        PREPARED_STATEMENT = super.getConnection().prepareStatement(deleteContact);
        PREPARED_STATEMENT.setLong(1, clients.getId());
        PREPARED_STATEMENT.executeUpdate();
        PREPARED_STATEMENT = super.getConnection().prepareStatement(deletePerson);
        PREPARED_STATEMENT.setLong(1, clients.getId());
        PREPARED_STATEMENT.executeUpdate();
        super.closeDB();
        return true;
    }

    @Override
    public @NonNull Client searchRow(Long id) throws SQLException, UserNotFound {
        PreparedStatement userStatement = super.connectionDB().prepareStatement(selectQueryUser);
        userStatement.setLong(1, id);
        ResultSet resultUser = userStatement.executeQuery();
        PreparedStatement addressStatement = super.getConnection().prepareStatement(selectQueryAddress);
        addressStatement.setLong(1, id);
        ResultSet resultAddress = addressStatement.executeQuery();
        PreparedStatement contactStatement = super.getConnection().prepareStatement(selectQueryContact);
        contactStatement.setLong(1, id);
        ResultSet resultContact = contactStatement.executeQuery();
        Client client;
        if (resultUser.next() && resultAddress.next() && resultContact.next()) {
            client = new Client(
                    resultUser.getInt("id"),
                    resultUser.getString("name"),
                    resultUser.getString("cpf"),
                    new Address(resultAddress.getString("rua"), resultAddress.getInt("number"), resultAddress.getString("bairro")),
                    new Contact(resultContact.getLong("telephone"), resultContact.getString("email")),
                    resultUser.getString("urlphoto"),
                    resultUser.getString("oab"),
                    resultUser.getString("role")
            );
            super.closeDB();
            return client;
        } else {
            super.closeDB();
            throw new UserNotFound("Usuário não existente");
        }
    }


    @Override
    public @NonNull Boolean insertRow(Client temp) throws SQLException {
        PREPARED_STATEMENT = super.connectionDB().prepareStatement(insertPerson, Statement.RETURN_GENERATED_KEYS);
        PREPARED_STATEMENT.setString(1, temp.getNome());
        PREPARED_STATEMENT.setString(2, temp.getCpf());
        PREPARED_STATEMENT.setString(3, temp.getUrlfoto());
        PREPARED_STATEMENT.setString(4, temp.getOab());
        PREPARED_STATEMENT.setString(5, temp.getAreaAtuacao());
        PREPARED_STATEMENT.executeUpdate();
        ResultSet generatedKeys = PREPARED_STATEMENT.getGeneratedKeys();
        Long key = -1l;
        if (generatedKeys.next()) {
            key = generatedKeys.getLong(1);
            PREPARED_STATEMENT = super.getConnection().prepareStatement(insertAddress);
            PREPARED_STATEMENT.setString(1, temp.getEndereco().getRua());
            PREPARED_STATEMENT.setInt(2, temp.getEndereco().getNumero());
            PREPARED_STATEMENT.setString(3, temp.getEndereco().getBairro());
            PREPARED_STATEMENT.setLong(4, key);
            PREPARED_STATEMENT.execute();
            PREPARED_STATEMENT = super.getConnection().prepareStatement(insertContact);
            PREPARED_STATEMENT.setLong(1, temp.getContato().getTelefone());
            PREPARED_STATEMENT.setString(2, temp.getContato().getEmail());
            PREPARED_STATEMENT.setLong(3, key);
            PREPARED_STATEMENT.execute();
        }
        super.closeDB();
        return true;
    }
}
