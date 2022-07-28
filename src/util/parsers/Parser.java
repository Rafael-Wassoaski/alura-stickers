package util.parsers;

import java.util.List;
import entity.Content;

public interface Parser {

    public List<Content> parse(String json);
    
}
