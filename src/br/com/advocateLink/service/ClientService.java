package br.com.advocateLink.service;

import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.interfaces.IService;
import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.shared.connections.database.commands.CommandsClient;

import java.sql.SQLException;
import java.util.List;

public class ClientService implements IService<Client> {
    private CommandsClient commandsClient = new CommandsClient();
    @Override
    public Client search(Long id) throws UserNotFound, SQLException {
        return commandsClient.searchRow(id);
    }

    @Override
    public Boolean delete(Client client) throws SQLException {
        commandsClient.deleteRow(client);
        return null;
    }

    @Override
    public Boolean alter(Long id, Client client) throws UserNotFound, SQLException {
        commandsClient.updateRow(id,client);
        return null;
    }

    @Override
    public Boolean register(Client client) throws SQLException {
        commandsClient.insertRow(client);
        return null;
    }

    @Override
    public List<Client> show() {
        return null;
    }
}
