package h2tk.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "IdentityUserClaims")
public class IdentityUserClaims {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "claim_type")
    private String claimType;

    @Column(name = "claim_value")
    private String claimValue;

    @Column(name = "application_user_id")
    private String applicationUserId;

    public IdentityUserClaims() {
    }

    public IdentityUserClaims(Integer id, String userId, String claimType, String claimValue,
            String applicationUserId) {
        this.id = id;
        this.userId = userId;
        this.claimType = claimType;
        this.claimValue = claimValue;
        this.applicationUserId = applicationUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(String claimValue) {
        this.claimValue = claimValue;
    }

    public String getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(String applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

    
}
