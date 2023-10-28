package br.com.advocateLink.classes.shared.connections.https;

import br.com.advocateLink.classes.models.Client;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**This class has responsibility for initializing HTTP.
 * @version 1.0
 * @author Guilherme Vinicius
 */
public abstract class HttpsInitialize {
    protected static HttpClient client = HttpClient.newHttpClient();
    protected static HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/client/api"))
            .build();
    protected static HttpResponse<String> response;

    static {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    protected static Gson gson = new Gson();
    /**
     * converts from Json to a System Object
     */
    protected static Client[] clients = gson.fromJson(response.body(), Client[].class);
    //Getters
    public static Client[] getClients() {
        return clients;
    }
}
