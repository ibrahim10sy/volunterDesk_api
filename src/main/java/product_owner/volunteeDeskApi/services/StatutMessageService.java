package product_owner.volunteeDeskApi.services;

import product_owner.volunteeDeskApi.models.StatutMessage;
import product_owner.volunteeDeskApi.repositories.StatutMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatutMessageService {

    @Autowired
    private StatutMessageRepository statutMessageRepository;

    public StatutMessage save(StatutMessage statutMessage) {
        return statutMessageRepository.save(statutMessage);
    }

    public StatutMessage update(StatutMessage statutMessage, Long id){
        StatutMessage re = statutMessageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune donnée trouvé"));
        re.setLibelleStatutMessage(statutMessage.getLibelleStatutMessage());
        return statutMessageRepository.save(re);
    }
    public List<StatutMessage> findAll(){
        return statutMessageRepository.findAll();
    }

    public void deleteById(Long id) {
        statutMessageRepository.deleteById(id);
    }
}
