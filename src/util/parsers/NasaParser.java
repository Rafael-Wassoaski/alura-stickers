package util.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import entity.Content;
import util.JSONParser;

public class NasaParser implements Parser{
    public List<Content> parse(String json) {
        JSONParser jsonParser = new JSONParser();
        List<Map<String, String>> contentStrings = jsonParser.parse(json);

        List<Content> contents = new ArrayList<>();

        for(Map<String, String> contentString : contentStrings){
            Content content = new Content(contentString.get("url"), contentString.get("title"));
            contents.add(content);
        }

        return contents;
    } 
}
