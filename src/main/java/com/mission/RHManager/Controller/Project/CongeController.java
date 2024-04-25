package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.Conge;

import com.mission.RHManager.Services.Projet.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin("*")
@RequestMapping("/conges")
public class CongeController {
private final CongeService congeService;

    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }


    @PostMapping
    public void saveConge(@RequestBody Conge conge) {
        congeService.saveConge(conge);
    }

    @GetMapping("/{id}")
    public Conge getCongeById(@PathVariable Long id) {
        return congeService.getCongeById(id);
    }

    @GetMapping
    public Iterable<Conge> getAllConges() {
        return congeService.getAllConges();
    }

    @PutMapping("/{id}")
    public Conge updateConge(@PathVariable Long id, @RequestBody Conge conge) {
        return congeService.updateConge(id, conge);
    }

    @DeleteMapping("/{id}")
    public void deleteConge(@PathVariable Long id) {
        congeService.deleteConge(id);
    }


    @GetMapping("/casual-leave-count")
    public int getCasualLeaveCount() {
        return congeService.getCasualLeaveCount();
    }

    @GetMapping("/sick-leave-count")
    public int getSickLeaveCount() {
        return congeService.getSickLeaveCount();
    }

    @GetMapping("/personal-days-count")
    public int getPersonalDaysCount() {
        return congeService.getPersonalDaysCount();
    }

}
