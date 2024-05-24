package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Equipe;
import com.mission.RHManager.Entites.EquipeHistorique;
import com.mission.RHManager.Entites.Projet;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Services.Projet.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/Equipe")
public class EquipeController {


    private final EquipeService equipeService;

    @GetMapping
    public List<Equipe> getEquipes(){return equipeService.getAllEquipe();}
    @PostMapping
    public void addEquipe(@RequestBody Equipe equipe) {
        System.out.println(equipe);

        equipeService.addEquipe(equipe);
    }
    @PutMapping("/{teamId}")
    public void updateEquipe(@PathVariable Long teamId, @RequestBody Equipe equipe) {
        equipeService.updateEquipe(teamId, equipe);
    }
    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
    }

    @GetMapping("/{id}")
    public Equipe getEquipe(@PathVariable Long id) {
        return equipeService.getEquipe(id);
    }

    @GetMapping("/getUsers")
    public List<Utilisateur> getUsers() {
        return equipeService.getAllUsers();
    }
    @GetMapping("/getProjects")
    public List<Projet> getProjects() {
        return equipeService.getAllProjects();
    }

@GetMapping("/teamMembers/{id}")
public List<Utilisateur> getMembres(@PathVariable Long id) {
        return equipeService.getMembres(id);
}
    @GetMapping("/teamManager/{id}")
    public Utilisateur getManager(@PathVariable Long id) {
        return equipeService.getManager(id);
    }

    @GetMapping("/teamProjects/{id}")
    public List<Projet> getProjects(@PathVariable Long id) {
        return equipeService.getProjets(id);
    }

    @PatchMapping("/addMembre/{teamId}/{UserId}")
    public void AddMember(@PathVariable Long teamId, @PathVariable Long UserId) {
        equipeService.AddUser(teamId, UserId);
    }
    @PatchMapping("/deleteMembre/{teamId}/{UserId}")
    public void deleteMember(@PathVariable Long teamId, @PathVariable Long UserId) {
        equipeService.deleteUser(teamId, UserId);
    }
    @PatchMapping("/addProject/{teamId}/{ProjectId}")
    public void AddProject(@PathVariable Long teamId, @PathVariable Long ProjectId) {
        equipeService.AddProject(teamId, ProjectId);
    }
    @PatchMapping("/deleteProject/{teamId}/{ProjectId}")
    public void deleteProject(@PathVariable Long teamId, @PathVariable Long ProjectId) {
        equipeService.deleteProject(teamId, ProjectId);
    }

    @GetMapping("/getTeamsByUser/{userId}")
    public List<Equipe> getTeamsByUserId(@PathVariable Long userId) {
        return equipeService.getTeamsByUserId(userId);
    }


    @GetMapping("/getTeamHistory/{id}")
public List<EquipeHistorique> getTeamHistory(@PathVariable Long id) {
        return equipeService.getAllTeamHistory(id);
    }
    @PostMapping("/addTeamHistory")
    public void addTeamHistory(@RequestBody EquipeHistorique equipeHistorique, @RequestBody Long teamId){
        equipeService.addEquipeHistorique(teamId,equipeHistorique);
    }


//    @GetMapping("/getAllProjects")
//    public List<Projet> getAllProjects() {
//        return equipeService.getAllProjects();
//    }
//
//    @GetMapping("/getAllManagers")
//    public List<Utilisateur> getAllManagers() {
//        return equipeService.getAllManagers();
//    }
//

}
