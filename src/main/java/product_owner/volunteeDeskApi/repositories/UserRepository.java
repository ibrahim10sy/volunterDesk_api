package product_owner.volunteeDeskApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import product_owner.volunteeDeskApi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public List<User> findAllByRole_libelleRole(String role);

    public User findByEmail(String email);
}
