package product_owner.volunteeDeskApi.repositories;

import product_owner.volunteeDeskApi.models.TypeOrganisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOrganisationRepository extends JpaRepository<TypeOrganisation, Long> {
}
