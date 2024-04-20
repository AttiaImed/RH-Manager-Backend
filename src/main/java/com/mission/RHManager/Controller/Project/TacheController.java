package com.mission.RHManager.Controller.Project;

import com.mission.RHManager.Entites.SousTache;
import com.mission.RHManager.Entites.Tache;
import com.mission.RHManager.Repositories.EquipeRepository;
import com.mission.RHManager.Repositories.ProjetRepository;
import com.mission.RHManager.Repositories.TacheRepository;
import com.mission.RHManager.Services.Projet.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tasks")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TacheController {
    private final EquipeRepository equipeRepository;
    private final ProjetRepository projectRepository;

    private final TacheRepository todosRepository;
    private final TacheService todosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tache>> getAllTeams() throws AccessDeniedException {
        //ModelMapper modelMapper = new ModelMapper();
        List<Tache> teams = todosRepository.findAll();
        return new ResponseEntity<List<Tache>>(teams, HttpStatus.OK);

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Tache CreateTask(@RequestBody Tache task) {
        return todosRepository.save(task);
    }
    @GetMapping(path="/{id}")
    public Tache getProjectById(@PathVariable long id) {
        return todosRepository.findById(id).get();
    }

    @PutMapping
    public Tache updateTodo(@RequestBody Tache todo) {
        return todosRepository.save(todo);
    }

    // Delete Skill Based on it's id
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id) {
        //Call SkillService to do the job
        todosRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path="/folder")
    public List<Tache> getTodosByFolderId( @RequestParam(value="idFolder",defaultValue = "1")  long idFolder){
        return todosRepository.findTacheByDossierId(idFolder);
    }

    @GetMapping(path="/user/{id}")
    public List<Tache> getTodosByUserId(@PathVariable long id){
        return todosRepository.findTacheByMembersId(id);
    }

    @GetMapping(path="/user/{projectId}/{userId}")
    public List<Tache> getTodosByProjectIdAndUserId(@PathVariable long projectId,@PathVariable long userId){
        return todosService.getTodosByProjectIdAndUserId(projectId,userId);
    }

    @GetMapping("/checklists/{userId}")
    public List<List<SousTache>> getValidatedChecklistsByUser(@PathVariable long userId) {
        return todosService.getValidatedChecklistsByUser(userId);
    }
}

