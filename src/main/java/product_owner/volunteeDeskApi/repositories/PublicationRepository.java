package product_owner.volunteeDeskApi.repositories;

import product_owner.volunteeDeskApi.models.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
