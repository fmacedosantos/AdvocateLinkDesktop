package classes.shared.client;

import classes.models.Clients;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class MethodsUtil {
    public static HttpClient client = HttpClient.newHttpClient();
    static HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/client/api"))
            .build();
    public static HttpResponse<String> response;

    static {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Gson gson = new Gson();
    public static Clients[] clients = gson.fromJson(response.body(), Clients[].class);

    // VALIDA SE UM CAMPO SERA STRING OU NUMERO, SE CASO FOR STRING RETORNARAR ERROR
    public static int validaNumero(Object numero) throws NumberFormatException {
        if ((numero instanceof String)) {
            throw new NumberFormatException();
        }
        return (int) numero;
    }

    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validaCampos(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6) {
        if (!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() && !tf5.getText().isEmpty() && !tf6.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validaCampos(JTextField tf1, JTextField tf2) {
        if (!tf1.getText().isEmpty() && !tf2.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // PESQUISA O CLIENTE A PARTIR DO NOME
    public static Clients searchClient(String name) throws NullPointerException {
        for (Clients c1 : MethodsUtil.clients) {
            if (c1.getNome().equals(name)) {
                System.out.println("achouuu");
                return c1;
            }
        }
        throw new NullPointerException();
    }

    // inicia a conexao com a API do Spring
    public static void getHttps() throws RuntimeException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/client/api"))
                .build();
        HttpResponse<String> response;
        {
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Gson gson = new Gson();
        clients = gson.fromJson(response.body(), Clients[].class);
    }

    // Adiciona informacao(Cliente) na API
    public static void postHttps(Clients tempClient) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        // Constroi a solicitação HTTP POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/client/api/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(MethodsUtil.gson.toJson(tempClient)))
                .build();
        System.out.println(MethodsUtil.gson.toJson(tempClient));
        // Enviando a solicitação e tendo a resposta
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // Lida com a resposta da API
        if (response.statusCode() == 201) {
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.out.println("Falha ao adicionar o cliente. Código de resposta: " + response.statusCode());
        }
    }
    public static void deleteHttps(long tempid) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        // Constroi a solicitação HTTP DELETE
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/client/api/"+tempid))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
