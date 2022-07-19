import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import util.JsonParser;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI address = new URI(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(address).GET().build();

        HttpResponse<String> httpResponse = client.send(httpRequest, BodyHandlers.ofString());
        String bodyResponse = httpResponse.body();

        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> moviesList = jsonParser.parse(bodyResponse);

        for (Map<String,String> movie : moviesList) {
            System.out.println("Title: " + movie.get("title"));
            System.out.println("Ratio: " + movie.get("imDbRating"));
            System.out.println("Image: " + movie.get("image"));
            System.out.println();
            
        }
    }
}
