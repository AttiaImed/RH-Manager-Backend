package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Equipe;
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



    @GetMapping("/getTeamsByUser/{userId}")
    public List<Equipe> getTeamsByUserId(@PathVariable Long userId) {
        return equipeService.getTeamsByUserId(userId);
    }

    @PostMapping("/addOrRemoveUser/{teamId}/{userId}")
    public void addOrRemoveUser(@PathVariable Long teamId, @PathVariable String userId) {
        equipeService.addOrRemoveUser(teamId, userId);
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
