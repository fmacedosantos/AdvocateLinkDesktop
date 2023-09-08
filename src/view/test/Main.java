package view.test;

import classes.shared.client.MethodsUtil;
import view.test.screens.Login;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Login login = new Login("AdvocateLink");
        login.setVisible(true);
        MethodsUtil.getHttps();// inicia a conexao com a API do Spring
    }
}
