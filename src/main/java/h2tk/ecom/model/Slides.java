package h2tk.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Slides")
public class Slides{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "caption")
    private String caption;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private boolean status;

    public Slides() {
    }

    public Slides(int id, String image, String caption, String content, boolean status) {
        this.id = id;
        this.image = image;
        this.caption = caption;
        this.content = content;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
