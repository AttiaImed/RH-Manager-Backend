package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Dossier")
public class DossierController {

    @Autowired
    DossierService dossierService;

    @PostMapping
    public void addDossier(@RequestBody Dossier dossier) {
        dossierService.addDossier(dossier);
    }

    @PutMapping
    public void updateDossier(@RequestBody Dossier dossier) {
        dossierService.updateDossier(dossier);
    }

    @DeleteMapping("/{id}")
    public void deleteDossier(@PathVariable Long id) {
        dossierService.deleteDossier(id);
    }

    @GetMapping("/{id}")
    public Optional<Dossier> getDossier(@PathVariable Long id) {
        return dossierService.getDossier(id);
    }

    @GetMapping
    public List<Dossier> getAllDossier() {
        return dossierService.getAllDossier();
    }
}
