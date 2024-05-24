package com.mission.RHManager.Controller;


import com.mission.RHManager.Entites.Presence;
import com.mission.RHManager.Entites.Reclamation;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Services.PresenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Presence")
@AllArgsConstructor
public class PresenceController {

private PresenceService presenceService;
    @PostMapping
    public ResponseEntity<Presence> createPresence(@RequestBody Presence presence) {
        Presence presenceResponse = presenceService.addPresence(presence);
        return new ResponseEntity<Presence>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Presence> getPresenceById(@PathVariable Long id) {
        Presence presence = presenceService.getPresenceById(id);
        if (presence != null) {
            return new ResponseEntity<>(presence, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Presence> updatePresence(@PathVariable Long id, @RequestBody Presence presence) {
        presence.setId(id);
        presenceService.updatePresence(presence);
        return new ResponseEntity<>(presence, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List<Utilisateur>>getAllPresence() {
        List<Utilisateur> presences = presenceService.getAllPresence();
        return new ResponseEntity<>(presences, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Presence>> getPresenceByUtilisateurId(@PathVariable Long id) {
        List<Presence> presence = presenceService.getPresenceByUtilisateurId(id);
        if (presence != null) {
            return new ResponseEntity<>(presence, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
