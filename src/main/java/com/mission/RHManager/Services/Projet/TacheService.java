package com.mission.RHManager.Services.Projet;


import com.mission.RHManager.Entites.SousTache;
import com.mission.RHManager.Entites.Tache;

import java.util.List;
import java.util.Optional;

public interface TacheService {
    // CRUD operations
    void addTache(Tache tache);
    void updateTache(Tache tache);
    void deleteTache(Long id);
    Optional<Tache> getTache(Long id);
    List<Tache> getAllTache();

    List<Tache> getTodosByProjectIdAndUserId(long projectId, long userId);

    List<List<SousTache>> getValidatedChecklistsByUser(long userId);
}
