package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Entites.Projet;
import com.mission.RHManager.Services.Projet.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Projet")
public class ProjetController {

    @Autowired
    ProjetService projetService;

    @PostMapping("/add/{teamId}")
    public Projet addProjet(@PathVariable Long teamId, @RequestBody Projet projet) {
        return projetService.addProjet(teamId, projet);
    }

    @PutMapping("/update/{projectId}")
    public Projet updateProjet(@PathVariable Long projectId, @RequestBody Projet projet) {
        return projetService.updateProjet(projectId, projet);
    }

    @DeleteMapping("/delete/{projectId}")
    public void deleteProjet(@PathVariable Long projectId) {
        projetService.deleteProjet(projectId);
    }

    @GetMapping("/get/{projectId}")
    public Projet getProjet(@PathVariable Long projectId) {
        return projetService.getProjet(projectId);
    }

    @GetMapping("/getAll")
    public List<Projet> getAllProjet() {
        return projetService.getAllProjet();
    }

    @PostMapping("/{id}/addFolder")
    public Projet addFolderToProject(@PathVariable Long id, @RequestBody Dossier dossier) {
        return projetService.addFolderToProject(id, dossier);
    }

    @GetMapping("/getProjectsByUser/{userId}")
    public List<Projet> getProjectsByUserId(@PathVariable Long userId) {
        return projetService.getProjectsByUserId(userId);
    }

    @GetMapping("/getProjectsBySupervisor/{supervisorId}")
    public List<Projet> getProjectsBySupervisorId(@PathVariable Long supervisorId) {
        return projetService.getProjectsBySupervisorId(supervisorId);
    }
}
