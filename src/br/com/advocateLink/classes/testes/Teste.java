package br.com.advocateLink.classes.testes;

import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.models.Address;
import br.com.advocateLink.classes.models.Contact;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.connections.database.ConnectionDataBase;
import br.com.advocateLink.classes.shared.connections.database.commands.CommandsEmployee;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) {
        try {
            ConnectionDataBase connectionDataBase = new ConnectionDataBase();
            connectionDataBase.connectionDB();
            CommandsEmployee employee = new CommandsEmployee();
            System.out.println(employee.searchRow(null));
//            employee.insertRow(new Employee("ultimo","123",new Address("qqqqq",1,"2"),new Contact(1234,"gui231"),
//                    "123",0,"teste",123));
        } catch (SQLException ex) {

        } catch (UserNotFound e) {
            throw new RuntimeException(e);
        }
        }
    }

