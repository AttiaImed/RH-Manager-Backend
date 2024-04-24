package com.mission.RHManager.Services.Projet;

    import com.mission.RHManager.Entites.Conge;
import java.util.List;

public interface CongeService {
    Conge saveConge(Conge conge);
    Conge getCongeById(Long id);
    List<Conge> getAllConges();
    Conge updateConge(Long id, Conge conge);
    void deleteConge(Long id);
}
