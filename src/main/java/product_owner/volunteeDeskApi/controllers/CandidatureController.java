package product_owner.volunteeDeskApi.controllers;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import product_owner.volunteeDeskApi.models.Candidature;
import product_owner.volunteeDeskApi.services.CandidatureService;


@RestController
@RequestMapping("/candidature")
public class CandidatureController {

    @Autowired
    CandidatureService cService;

    @PostMapping("/addCandidature")
    @Operation(summary="Création de candidature")
    public ResponseEntity<Candidature> createCandidature(@RequestBody Candidature candidature) {
        System.out.println(candidature.toString());
        return new ResponseEntity<>(cService.save(candidature) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<Candidature> updateCandidature(@PathVariable Long id, @RequestBody Candidature candidature) {
        return new ResponseEntity<>(cService.update(candidature, id), HttpStatus.OK);
    }

    @GetMapping("/getAllCandidature")
    @Operation(summary="Liste de tout les candidature")
    public ResponseEntity<List<Candidature>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    @Operation(summary="Liste d'un candidature")
    public ResponseEntity<Candidature> getAllById(@PathVariable Long idCandidature){
        return new ResponseEntity<>(cService.findById(idCandidature), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCandidature(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }

}
