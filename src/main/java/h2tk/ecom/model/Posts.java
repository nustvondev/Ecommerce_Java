package h2tk.ecom.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "image")
    private String image;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "content", columnDefinition = "nvarchar(max)")
    private String content;

    @Column(name = "home_flag")
    private Boolean homeFlag;

    @Column(name = "hot_flag")
    private Boolean hotFlag;

    @Column(name = "view_count")
    private Integer viewCount;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getHomeFlag() {
        return homeFlag;
    }

    public void setHomeFlag(Boolean homeFlag) {
        this.homeFlag = homeFlag;
    }

    public Boolean getHotFlag() {
        return hotFlag;
    }

    public void setHotFlag(Boolean hotFlag) {
        this.hotFlag = hotFlag;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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

    public Posts(Integer id, String name, String alias, Integer categoryId, String image, String description,
            String content, Boolean homeFlag, Boolean hotFlag, Integer viewCount, Date createdDate, String createdBy,
            Date updatedDate, String updatedBy, String metaKeyword, String metaDescription, Boolean status) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.categoryId = categoryId;
        this.image = image;
        this.description = description;
        this.content = content;
        this.homeFlag = homeFlag;
        this.hotFlag = hotFlag;
        this.viewCount = viewCount;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.metaKeyword = metaKeyword;
        this.metaDescription = metaDescription;
        this.status = status;
    }

    public Posts() {
    }

}
