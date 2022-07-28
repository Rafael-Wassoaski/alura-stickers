package entity;

import java.util.Map;

public class Content {
    private String imageUrl;
    private String title;

    public Content(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
}
