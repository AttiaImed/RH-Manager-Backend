package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Equipe;
import com.mission.RHManager.Services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
public class EquipeController {

    @Autowired
    EquipeService equipeService;

    @PostMapping("/add")
    public void addEquipe(@RequestBody Equipe equipe) {
        equipeService.addEquipe(equipe);
    }

    @PutMapping("/update/{teamId}")
    public void updateEquipe(@PathVariable Long teamId, @RequestBody Equipe equipe) {
        equipeService.updateEquipe(teamId, equipe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
    }

    @GetMapping("/get/{id}")
    public Equipe getEquipe(@PathVariable Long id) {
        return equipeService.getEquipe(id);
    }

    @GetMapping("/getAll")
    public List<Equipe> getAllEquipe() {
        return equipeService.getAllEquipe();
    }

    @GetMapping("/getTeamsByUser/{userId}")
    public List<Equipe> getTeamsByUserId(@PathVariable Long userId) {
        return equipeService.getTeamsByUserId(userId);
    }

    @PostMapping("/addOrRemoveUser/{teamId}/{userId}")
    public void addOrRemoveUser(@PathVariable Long teamId, @PathVariable String userId) {
        equipeService.addOrRemoveUser(teamId, userId);
    }
}
