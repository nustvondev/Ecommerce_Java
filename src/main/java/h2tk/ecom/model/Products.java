package h2tk.ecom.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Column(name = "image")
    private String image;

    @Column(name = "more_images", columnDefinition = "xml")
    private String moreImages;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "promotion_price")
    private double promotionPrice;

    @Column(name = "warranty")
    private int warranty;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "content", columnDefinition = "nvarchar(max)")
    private String content;

    @Column(name = "home_flag")
    private Boolean homeFlag;

    @Column(name = "hot_flag")
    private Boolean hotFlag;

    @Column(name = "view_count")
    private int viewCount;

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

    @Column(name = "tags", columnDefinition = "nvarchar(max)")
    private String tags;

    @Column(name = "quantity", nullable = false)
    private  int quantity;

    public Products() {
    }

    public Products(int id, String name, String alias, String image, String moreImages, double price,
            double promotionPrice, int warranty, String description, String content, Boolean homeFlag, Boolean hotFlag,
            int viewCount, Date createdDate, String createdBy, Date updatedDate, String updatedBy, String metaKeyword,
            String metaDescription, Boolean status, String tags, int quantity) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.image = image;
        this.moreImages = moreImages;
        this.price = price;
        this.promotionPrice = promotionPrice;
        this.warranty = warranty;
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
        this.tags = tags;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMoreImages() {
        return moreImages;
    }

    public void setMoreImages(String moreImages) {
        this.moreImages = moreImages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
