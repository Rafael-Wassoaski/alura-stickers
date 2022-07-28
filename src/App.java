import java.io.InputStream;
import java.net.URL;
import java.util.List;
import entity.Content;
import util.parsers.NasaParser;

public class App {
    public static void main(String[] args) throws Exception {
        // String url = "https://alura-imdb-api.herokuapp.com/movies";
        String url =
                "https://api.nasa.gov/planetary/apod?api_key=M7DOB8pg3CzacxS7DN2SCsXh2kObwfOB9KjG00FJ&start_date=2022-06-12";

        HttpClientRequester nasaRequester = new HttpClientRequester();
        String bodyResponse = nasaRequester.get(url);

        NasaParser nasaParser = new NasaParser();
        List<Content> contentList = nasaParser.parse(bodyResponse);

        StickerGenerator stickerGenerator = new StickerGenerator();

        for (Content content : contentList) {
            System.out.println("Title: " + content.getTitle());
            // System.out.println("Ratio: " + movie.get("imDbRating"));
            System.out.println("Image: " + content.getImageUrl());
            System.out.println();

            InputStream inputStream = new URL(content.getImageUrl()).openStream();
            stickerGenerator.generateSticker(inputStream, content.getTitle());
        }
    }
}
