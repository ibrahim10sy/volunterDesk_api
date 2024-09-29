package product_owner.volunteeDeskApi.repositories;

import product_owner.volunteeDeskApi.models.Ressource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long> {
}
