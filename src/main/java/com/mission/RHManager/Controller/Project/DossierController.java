package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Services.Projet.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Dossier")
public class DossierController {

    @Autowired
    DossierService dossierService;

    @PostMapping
    public ResponseEntity<Void> addDossier(@RequestBody Dossier dossier) {
        dossierService.addDossier(dossier);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDossier(@PathVariable Long id, @RequestBody Dossier dossier) {
        dossier.setId(id); // Set the ID from the path variable into the Dossier object
        dossierService.updateDossier(dossier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable Long id) {
        dossierService.deleteDossier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dossier> getDossier(@PathVariable Long id) {
        Optional<Dossier> dossier = dossierService.getDossier(id);
        return dossier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Dossier>> getAllDossier() {
        List<Dossier> dossiers = dossierService.getAllDossier();
        return new ResponseEntity<>(dossiers, HttpStatus.OK);
    }
}