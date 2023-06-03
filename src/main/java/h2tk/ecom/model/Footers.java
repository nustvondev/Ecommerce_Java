package h2tk.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Footers")
public class Footers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Footers(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Footers() {
    }
}
