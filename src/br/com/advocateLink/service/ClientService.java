package br.com.advocateLink.service;

import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.exceptions.handler.ErrorHandler;
import br.com.advocateLink.classes.interfaces.IService;
import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.connections.database.commands.CommandsClient;

import java.sql.SQLException;
import java.util.List;

public class ClientService implements IService<Client> {
    private CommandsClient commandsClient = new CommandsClient();
    private ErrorHandler errorHandler = new ErrorHandler();
    @Override
    public Client search(Long id){
        try{
            Client c = commandsClient.searchRow(id);
            if (c.getOab()==null){
                throw new UserNotFound("Cliente nao encontrado");
            }
            return c;
        }catch (UserNotFound ex){
            errorHandler.userNotFoundHandler(new UserNotFound("usuario incorreto"));
            throw new RuntimeException();
        }catch (SQLException ex){
            errorHandler.sqlHandler(new SQLException("Falha na conexao: "+ ex.getMessage()));
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean delete(Client client){
        try{
            commandsClient.deleteRow(client);
        }catch (UserNotFound ex){
            errorHandler.userNotFoundHandler(new UserNotFound("usuario incorreto"));
            throw new RuntimeException();
        }catch (SQLException ex){
            errorHandler.sqlHandler(new SQLException("Falha na conexao: "+ ex.getMessage()));
            throw new RuntimeException();
        }

        return null;
    }

    @Override
    public Boolean alter(Long id, Client client){
        try{
            commandsClient.updateRow(id,client);
        }catch (UserNotFound ex){
            errorHandler.userNotFoundHandler(new UserNotFound("usuario incorreto"));
            throw new RuntimeException();
        }catch (SQLException ex){
            errorHandler.sqlHandler(new SQLException("Falha na conexao: "+ ex.getMessage()));
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public Boolean register(Client client) {
        try{
            commandsClient.insertRow(client);
        }catch (SQLException ex){
            errorHandler.sqlHandler(new SQLException("Falha na conexao: "+ ex.getMessage()));
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public List<Client> show() {
        return null;
    }
}
