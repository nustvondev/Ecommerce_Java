package h2tk.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "IdentityUserLogins")
public class IdentityUserLogins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name = "login_provider")
    private String loginProvider;

    @Column(name = "provider_key")
    private String providerKey;

    @Column(name = "application_user_id")
    private String applicationUserId;

    public IdentityUserLogins() {
    }

    public IdentityUserLogins(String userId, String loginProvider, String providerKey, String applicationUserId) {
        this.userId = userId;
        this.loginProvider = loginProvider;
        this.providerKey = providerKey;
        this.applicationUserId = applicationUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginProvider() {
        return loginProvider;
    }

    public void setLoginProvider(String loginProvider) {
        this.loginProvider = loginProvider;
    }

    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }

    public String getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(String applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

    
}
