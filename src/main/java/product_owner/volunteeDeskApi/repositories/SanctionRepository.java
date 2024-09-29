package product_owner.volunteeDeskApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import product_owner.volunteeDeskApi.models.Sanction;

@Repository
public interface SanctionRepository extends JpaRepository<Sanction, Long> {
}
