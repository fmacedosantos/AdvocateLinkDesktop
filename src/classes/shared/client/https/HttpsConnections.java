package classes.shared.client.https;

import classes.models.Clients;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class HttpsConnections extends HttpsUtil {

    // inicia a conexao com a API do Spring
    public static void getHttps() throws RuntimeException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/client/api"))
                .build();
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
        client = HttpClient.newHttpClient();
        // Constroi a solicitação HTTP POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/client/api/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(tempClient)))
                .build();
        System.out.println(gson.toJson(tempClient));
        // Enviando a solicitação e tendo a resposta
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Lida com a resposta da API
        if (response.statusCode() == 201) {
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.out.println("Falha ao adicionar o cliente. Código de resposta: " + response.statusCode());
        }
    }
    //FAZ CHAMADA DE DELETE DO USUARIO PASSADO PELO PARAMETRO
    public static void deleteHttps(long tempid) throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        // Constroi a solicitação HTTP DELETE
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/client/api/"+tempid))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
    //ALTERAR AS INFORMACOES DO CLIENT
    public static void alterClient(long id, Clients tempClient) throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        // Constroi a solicitação HTTP POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/client/api/"+id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(tempClient)))
                .build();
        // Enviando a solicitação e tendo a resposta
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Lida com a resposta da API
        if (response.statusCode() == 201) {
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.out.println("Falha ao adicionar o cliente. Código de resposta: " + response.statusCode());
        }
    }
}
