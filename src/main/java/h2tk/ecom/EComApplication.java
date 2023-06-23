package h2tk.ecom;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EComApplication {
    private final JdbcTemplate jdbcTemplate;
    public EComApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public static void main(String[] args) {
        SpringApplication.run(EComApplication.class, args);
    }
    @PostConstruct
    public void initializeAdminAccount() {

        /*
        task:   insert genders
                insert roles
                insert status
        */

//        int adminCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user WHERE role = 'admin'", Integer.class);
//
//        if (adminCount == 0) {
//            String insertQuery = "INSERT INTO user (name, email, role, password) VALUES ('admin', 'admin@example.com', 'admin', 'password')";
//            jdbcTemplate.update(insertQuery);
//            System.out.println("Created admin account successfully.");
//        } else {
//            System.out.println("Admin account already exists.");
//        }
    }
}
