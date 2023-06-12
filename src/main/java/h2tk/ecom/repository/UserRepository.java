package h2tk.ecom.repository;

import h2tk.ecom.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
