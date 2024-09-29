package product_owner.volunteeDeskApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import product_owner.volunteeDeskApi.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
