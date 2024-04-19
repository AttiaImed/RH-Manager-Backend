package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Entites.Projet;
import com.mission.RHManager.Services.Projet.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Project")
@RequiredArgsConstructor
public class ProjetController {

    private final ProjetService projetService;


    // Merge Two Teams try it



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Projet>> getAllProjects()  {
        //ModelMapper modelMapper = new ModelMapper();
        List<Projet> teams = projetService.getAllProjet();

        return new ResponseEntity<List<Projet>>(teams,HttpStatus.OK);

    }
    @PostMapping(path="/{teamId}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Projet CreateProject(@PathVariable long teamId, @RequestBody Projet projetResponse) {
        Projet p = projetService.addProjet(teamId, projetResponse);

        return p;
    }
    @GetMapping(path="/{id}")
    public Projet getProjectById(@PathVariable long id) {

        return projetService.getProjetById(id);
    }

    @PatchMapping(path="/addfolder/{id}")
    public Projet addFolder(@PathVariable long id, @RequestBody Dossier f) {
        Projet p = projetService.addFolderToProject(id,f);
        return p;
    }

    @PatchMapping(path="/folder/{id}")
    public Projet updateFolder(@PathVariable long id, @RequestBody Dossier f) {
        Projet p = projetService.updateFolder(id,f);
        return p;
    }

    @PutMapping(path="/{projectId}")
    public Projet updateProject(@PathVariable long projectId,@RequestBody Projet project) {
        Projet p = projetService.updateProjet(projectId,project);

        return p;
    }
    // Delete Skill Based on it's id
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id) {
        //Call SkillService to do the job
        projetService.deleteProjet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //get project by user id
    @GetMapping(path="/user/{id}")
    public List<Projet> getProjectsByUserId(@PathVariable long id){
        return projetService.getProjectsByUserId(id);
    }
    //get project by superviserid id
    @GetMapping(path="/superviser/{id}")
    public List<Projet> getProjectsBySuperviserrId(@PathVariable long id){
        return projetService.getProjectsBySupervisorId(id);
    }
}