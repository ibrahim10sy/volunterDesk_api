package product_owner.volunteeDeskApi.repositories;

import product_owner.volunteeDeskApi.models.StatutMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutMessageRepository extends JpaRepository<StatutMessage,Long> {
}
