package classes.shared.client.https;

import classes.models.Clients;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class HttpsUtil {
    protected static HttpClient client = HttpClient.newHttpClient();
    protected static HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/client/api"))
            .build();
    protected static HttpResponse<String> response;

    static {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    protected static Gson gson = new Gson();
    protected static Clients[] clients = gson.fromJson(response.body(), Clients[].class);
    //Getters
    public static Clients[] getClients() {
        return clients;
    }
}
