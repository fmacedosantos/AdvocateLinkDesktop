package br.com.advocateLink.view;
import br.com.advocateLink.connections.database.ConnectionDataBase;
import br.com.advocateLink.view.screens.Login;
import javax.swing.*;
import java.sql.SQLException;

public class Main {
    private static ConnectionDataBase dataBase = new ConnectionDataBase();
    public static void main(String[] args) throws SQLException {
        Login login = new Login("AdvocateLink");
        login.setVisible(true);
        try {
            dataBase.connectionDB();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"VOCE ESTA SEM CONEXAO COM BD, TENTE MAIS TARDE");
            System.exit(0);
        } finally {
            dataBase.closeDB();
            JOptionPane.showMessageDialog(null,"OLA usuario, para que voce nao fique 1 hora procurando a senha para entrar no sistema, tome aqui: login: admin  senha: admin  , Muito Obrigado :)");
        }
    }
}
