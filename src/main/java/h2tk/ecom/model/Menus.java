package h2tk.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Menus")
public class Menus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "url") 
    private String url;

    @Column(name = "display_order")
    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private MenuGroups groupId;

    @Column(name = "target")
    private String target;

    @Column(name = "status")
    private Boolean status;

    
}
