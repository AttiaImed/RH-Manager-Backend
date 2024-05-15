package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Entites.Projet;
import com.mission.RHManager.Services.Projet.DossierService;
import com.mission.RHManager.Services.Projet.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Dossier")
@RequiredArgsConstructor
public class DossierController {


    private final DossierService dossierService;
    private final ProjetService projetService;
    @PostMapping(path="/{projetId}")
    public ResponseEntity<Dossier> addDossier(@PathVariable long projetId,@RequestBody Dossier dossier) {
        Projet projet = projetService.getProjetById(projetId);
        Dossier dossierInput = new Dossier();
        dossierInput.setGoals(dossier.getGoals());
        dossierInput.setNom(dossier.getNom());
        dossierInput.setProjet(projet);
        dossierInput.setStatus("Open");
        Dossier dossierResponse = dossierService.addDossier(dossierInput);
        projet.getDossiers().add(dossierResponse);
        projetService.updateProjet(projetId,projet);
        return new ResponseEntity<Dossier>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dossier> updateDossier(@PathVariable long id,@RequestBody Dossier dossier) {
        Dossier dossier1 = dossierService.getDossier(id);
        dossier1.setNom(dossier.getNom());
        dossier1.setGoals(dossier.getGoals());
        dossier1.setStatus(dossier.getStatus());
        if(dossier1.getStatus().equals("Completed")){
            dossier1.setProgress(100);
        }
        Dossier dossierResponse = dossierService.updateDossier(dossier1);
        return new ResponseEntity<Dossier>(dossierResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable Long id) {
        dossierService.deleteDossier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dossier> getDossier(@PathVariable Long id) {
        Dossier dossier = dossierService.getDossier(id);
        return new ResponseEntity<Dossier>(dossier, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Dossier>> getAllDossier() {
        List<Dossier> dossiers = dossierService.getAllDossier();
        return new ResponseEntity<>(dossiers, HttpStatus.OK);
    }
}