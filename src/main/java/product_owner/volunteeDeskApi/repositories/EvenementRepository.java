package product_owner.volunteeDeskApi.repositories;

import product_owner.volunteeDeskApi.models.Evenement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
