package br.com.alura.fotosapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("fotosapi")
public class Foto {
    @Id
    private String id;
    private String title;
    private String image;
    
    public Foto(String title, String image) {
        this.title = title;
        this.image = image;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
}