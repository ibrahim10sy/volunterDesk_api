package product_owner.volunteeDeskApi.services;

import product_owner.volunteeDeskApi.models.Role;
import product_owner.volunteeDeskApi.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Méthode pour créer sauvegarder un admin
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Role role, Long id) {
        Role r = roleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun role trouvé") );

        r.setLibelleRole(role.getLibelleRole());

        return roleRepository.save(r);
    }

    // Méthode pour afficher tous les admins
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role getById(Long id){
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun role trouvé") );
        return role;
    }

    // Méthode pour supprimer un 
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

}



