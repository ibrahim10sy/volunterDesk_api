package product_owner.volunteeDeskApi.services;

import org.springframework.stereotype.Service;

import product_owner.volunteeDeskApi.models.TypeEvenement;
import product_owner.volunteeDeskApi.repositories.TypeEvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class TypeEvenementService {
    
    @Autowired
    private TypeEvenementRepository tRepository;

    public TypeEvenement save(TypeEvenement typeEvenement) {
        return tRepository.save(typeEvenement);
    }

    public TypeEvenement update(TypeEvenement typeEvenement, Long id){
        TypeEvenement re = tRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune donnée trouvé"));
        re.setLibelleTypeEvenement(typeEvenement.getLibelleTypeEvenement());
        return tRepository.save(re);
    }
    public List<TypeEvenement> findAll(){
        return tRepository.findAll();
    }

    public void deleteById(Long id) {
        tRepository.deleteById(id);
    }
}
