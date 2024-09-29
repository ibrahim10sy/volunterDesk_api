package product_owner.volunteeDeskApi.services;

import product_owner.volunteeDeskApi.models.Candidature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import product_owner.volunteeDeskApi.repositories.CandidatureRepository;

@Service
public class CandidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;

    public Candidature save(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    public Candidature update(Candidature c, Long id){
        Candidature ca = candidatureRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun candidature trouvé") );

        ca.setLibelleCandidature(c.getLibelleCandidature());
        ca.setEtatCandidature(c.getEtatCandidature());
        ca.setDateCandidature(c.getDateCandidature());

        return candidatureRepository.save(ca);
    }


    public List<Candidature> findAll(){
        return candidatureRepository.findAll();
    }

    public Candidature findById(Long id) {
        Candidature c = candidatureRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun candidature trouvé") );
        return c;
    }

    public void deleteById(Long id) {
        candidatureRepository.deleteById(id);
    }
}
