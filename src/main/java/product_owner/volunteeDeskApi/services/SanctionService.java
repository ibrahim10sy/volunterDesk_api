package product_owner.volunteeDeskApi.services;

import product_owner.volunteeDeskApi.models.Notification;
import product_owner.volunteeDeskApi.models.Sanction;
import product_owner.volunteeDeskApi.repositories.NotificationRepository;
import product_owner.volunteeDeskApi.repositories.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanctionService {

    @Autowired
    private SanctionRepository sanctionRepository;

    public Sanction save(Sanction sanction) {
        return sanctionRepository.save(sanction);
    }

    public Sanction update(Sanction s, Long id ){
        Sanction sanction =  sanctionRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sanction trouvé"));
        sanction.setLibelleSanction(s.getLibelleSanction());
        sanction.setMotifSanction(s.getMotifSanction());
        return sanctionRepository.save(sanction);
    }

    public List<Sanction> findAll(){return sanctionRepository.findAll();}

    public Sanction findById(Long id) {
        Sanction sanction =  sanctionRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sanction trouvé"));
        return sanction;
    }

  

    public void deleteById(Long id) {
        sanctionRepository.deleteById(id);
    }
}
