import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpClient;


public class HttpClientRequester {
    public String get(String url){
        try {
            URI address = new URI(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder(address).GET().build();
    
            HttpResponse<String> httpResponse = client.send(httpRequest, BodyHandlers.ofString());
            String bodyResponse = httpResponse.body();
    
            return bodyResponse;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
       
    }
}
