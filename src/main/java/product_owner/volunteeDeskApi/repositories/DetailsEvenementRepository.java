package product_owner.volunteeDeskApi.repositories;

import product_owner.volunteeDeskApi.models.DetailsEvenement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsEvenementRepository extends JpaRepository<DetailsEvenement, Long> {

    public DetailsEvenement findByEvenement_idEvenement(Long idEvenement);
}
