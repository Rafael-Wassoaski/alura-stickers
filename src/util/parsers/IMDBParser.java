package util.parsers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entity.Content;
import util.JSONParser;

public class IMDBParser {
    public List<Content> parse(String json) {
        JSONParser jsonParser = new JSONParser();
        List<Map<String, String>> contentStrings = jsonParser.parse(json);

        List<Content> contents = new ArrayList<>();

        for(Map<String, String> contentString : contentStrings){
            Content content = new Content(contentString.get("image"), contentString.get("title"));
            contents.add(content);
        }

        return contents;
    } 
}