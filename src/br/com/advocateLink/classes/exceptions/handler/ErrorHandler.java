package br.com.advocateLink.classes.exceptions.handler;

import br.com.advocateLink.classes.exceptions.NegativeNumberException;
import br.com.advocateLink.classes.exceptions.UserNotFound;
import lombok.Getter;

import javax.swing.*;
import java.sql.SQLException;

@Getter
public class ErrorHandler {
    public void userNotFoundHandler(UserNotFound x){
        JOptionPane.showMessageDialog(null,x.getMessage());
    }
    public void sqlHandler(SQLException x){
        JOptionPane.showMessageDialog(null,x.getMessage());
    }
    public void negativeNumberHandler(NegativeNumberException x){
        JOptionPane.showMessageDialog(null,x.getMessage());
    }
}
