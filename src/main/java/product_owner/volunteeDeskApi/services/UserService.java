package product_owner.volunteeDeskApi.services;

import lombok.AllArgsConstructor;
import product_owner.volunteeDeskApi.models.User;

import product_owner.volunteeDeskApi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public User save(User user  , MultipartFile photo1, MultipartFile photo2) throws Exception {
        String passWordHasher = passwordEncoder.encode(user.getMotDePasse());
        user.setMotDePasse(passWordHasher);
        //image
         if (photo1 != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo1.getInputStream(),
                            rootlocation.resolve(photo1.getOriginalFilename()));
                            user.setPhotoUser("photo/"
                            + photo1.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo1.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo1.getInputStream(),
                                    rootlocation.resolve(photo1.getOriginalFilename()));
                                    user.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo1.getInputStream(), rootlocation.resolve(photo1.getOriginalFilename()));
                            user.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }
         //image
         if (photo2 != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo2.getInputStream(),
                            rootlocation.resolve(photo2.getOriginalFilename()));
                            user.setPhotoProfil("photo/"
                            + photo2.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo2.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo2.getInputStream(),
                                    rootlocation.resolve(photo2.getOriginalFilename()));
                                    user.setPhotoProfil("photo/"
                                    + photo2.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo2.getInputStream(), rootlocation.resolve(photo2.getOriginalFilename()));
                            user.setPhotoProfil("photo/"
                                    + photo2.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }

        return userRepository.save(user);
    }

    public User update(User user  ,Long id, MultipartFile photo1, MultipartFile photo2) throws Exception {
        User u = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun user trouvé"));
        
        u.setNomUser(user.getNomUser());
        u.setPrenomUser(user.getPrenomUser());
        u.setDescription(user.getDescription());
        u.setEmail(user.getEmail());
        u.setTelephone(user.getTelephone());
        u.setDateNaissance(user.getDateNaissance());
        u.setNumCarteIdentification(user.getNumCarteIdentification());
        u.setCompetences(user.getCompetences());
        u.setAnneeExperiences(user.getAnneeExperiences());
        u.setNbrSuspension(user.getNbrSuspension());

        //image
         if (photo1 != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo1.getInputStream(),
                            rootlocation.resolve(photo1.getOriginalFilename()));
                            u.setPhotoUser("photo/"
                            + photo1.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo1.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo1.getInputStream(),
                                    rootlocation.resolve(photo1.getOriginalFilename()));
                                    u.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo1.getInputStream(), rootlocation.resolve(photo1.getOriginalFilename()));
                            u.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }
         //image
         if (photo2 != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo2.getInputStream(),
                            rootlocation.resolve(photo2.getOriginalFilename()));
                            u.setPhotoProfil("photo/"
                            + photo2.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo2.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo2.getInputStream(),
                                    rootlocation.resolve(photo2.getOriginalFilename()));
                                    user.setPhotoProfil("photo/"
                                    + photo2.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo2.getInputStream(), rootlocation.resolve(photo2.getOriginalFilename()));
                            u.setPhotoProfil("photo/"
                                    + photo2.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }

        return userRepository.save(user);
    }


    public List<User> findAllByRole(String role){
        return userRepository.findAllByRole_libelleRole(role);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User updatePassWord(Long id, String newPassWord) throws Exception {
        Optional<User> userOpt = userRepository.findById(id);
    
        if (userOpt.isPresent()) {
            User user = userOpt.get();
    
            // Hacher le nouveau mot de passe
            String hashedPassword = passwordEncoder.encode(newPassWord);
            user.setMotDePasse(hashedPassword);
            return userRepository.save(user);
        } else {
            throw new Exception("User non trouvé avec l'ID : " + id);
        }
    }

     public User connexion(String email, String password){
        User user = userRepository.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getMotDePasse())) {
            throw new EntityNotFoundException("Email ou mot de passe incorrect");
        }
        return user;
        }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
