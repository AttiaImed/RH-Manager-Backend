package com.mission.RHManager.Services;

import com.mission.RHManager.Entites.Dossier;

import java.util.List;
import java.util.Optional;

public interface DossierService {
    void addDossier(Dossier dossier);
    void updateDossier(Dossier dossier);
    void deleteDossier(Long id);
    Optional<Dossier> getDossier(Long id);
    List<Dossier> getAllDossier();
}
