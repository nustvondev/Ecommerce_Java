package h2tk.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "IdentityRoles")
public class IdentityRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    public IdentityRoles() {
    }

    public IdentityRoles(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
