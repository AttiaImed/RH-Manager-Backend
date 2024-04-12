package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Tache;
import com.mission.RHManager.Services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tache")
public class TacheController {

    @Autowired
    TacheService tacheService;

    @PostMapping("/add")
    public void addTache(@RequestBody Tache tache) {
        tacheService.addTache(tache);
    }

    @PutMapping("/update")
    public void updateTache(@RequestBody Tache tache) {
        tacheService.updateTache(tache);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTache(@PathVariable Long id) {
        tacheService.deleteTache(id);
    }

    @GetMapping("/{id}")
    public Optional<Tache> getTache(@PathVariable Long id) {
        return tacheService.getTache(id);
    }

    @GetMapping
    public List<Tache> getAllTache() {
        return tacheService.getAllTache();
    }
}
