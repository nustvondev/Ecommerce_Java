package h2tk.ecom.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "PostCategories")
public class PostCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "image")
    private String image;

    @Column(name = "home_flag")
    private Boolean homeFlag;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "meta_keyword", length = 256)
    private String metaKeyword;

    @Column(name = "meta_description", length = 256)
    private String metaDescription;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public PostCategories() {
    }

    public PostCategories(Integer id, String name, String alias, String description, Integer parentId,
            Integer displayOrder, String image, Boolean homeFlag, Date createdDate, String createdBy, Date updatedDate,
            String updatedBy, String metaKeyword, String metaDescription, Boolean status) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.description = description;
        this.parentId = parentId;
        this.displayOrder = displayOrder;
        this.image = image;
        this.homeFlag = homeFlag;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.metaKeyword = metaKeyword;
        this.metaDescription = metaDescription;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getHomeFlag() {
        return homeFlag;
    }

    public void setHomeFlag(Boolean homeFlag) {
        this.homeFlag = homeFlag;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
