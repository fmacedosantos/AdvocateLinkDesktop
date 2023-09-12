package view.test;

import classes.shared.client.https.HttpsConnections;
import view.test.screens.Login;
import view.test.screens.Mainscreen;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public enum AppConnectState {
        ON,
        OFF,;
    }
    public static AppConnectState currentConnectState;
    public static void main(String[] args) throws IOException, InterruptedException {
        Login login = new Login("AdvocateLink");
        login.setVisible(true);
        try {
            HttpsConnections.getHttps();// inicia a conexao com a API do Spring
            currentConnectState=AppConnectState.ON;
        }catch (ExceptionInInitializerError ex){
            JOptionPane.showMessageDialog(null,"VOCE ESTA INICIANDO O APP NO MODO OFF");
            JOptionPane.showMessageDialog(null,"Falha ao tentar acessar a API ADVOCATE-Link,Por favor, verifique se a conexao com a API ADVOCATE-Link esta sicronizada ou iniciada, para mais ajuda acesse: "+ "https://github.com/guilhermevini2013/Advocatelink-APPDesktop-consumindo-API");
            currentConnectState=AppConnectState.OFF;
        }
    }
}
