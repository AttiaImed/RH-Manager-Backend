package com.mission.RHManager.Controller.Reclamation;

import com.mission.RHManager.Entites.Reclamation;
import com.mission.RHManager.Services.Reclamation.ReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("Reclamation")
@AllArgsConstructor
public class ReclamationController {
    private ReclamationService reclamationService;
    @PostMapping
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        Reclamation reclamationResponse = reclamationService.saveReclamation(reclamation);
        return new ResponseEntity<Reclamation>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable Long id) {
        Reclamation reclamation = reclamationService.getReclamationById(id);
        if (reclamation != null) {
            return new ResponseEntity<>(reclamation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity <List<Reclamation>>getAllReclamations() {
        List<Reclamation> reclamations = reclamationService.getAllReclamations();
        return new ResponseEntity<>(reclamations, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id, @RequestBody Reclamation reclamation) {
        reclamation.setId(id);
        reclamationService.updateReclamation(reclamation);
        return new ResponseEntity<>(reclamation, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
