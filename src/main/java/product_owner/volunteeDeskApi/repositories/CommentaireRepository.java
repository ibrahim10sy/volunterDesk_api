package product_owner.volunteeDeskApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import product_owner.volunteeDeskApi.models.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    public List<Commentaire> findByPublication_idPublication(Long id);
}
