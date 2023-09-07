package view.test;

import classes.models.Clients;
import com.google.gson.Gson;
import view.test.screens.Login;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
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
    public static void main(String[] args) throws IOException, InterruptedException {
        Login login = new Login("AdvocateLink") ;
        login.setVisible(true);
    }
}
