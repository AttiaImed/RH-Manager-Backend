package com.mission.RHManager.Services.Projet;

import com.mission.RHManager.Entites.Dossier;

import java.util.List;
import java.util.Optional;

public interface DossierService {
    Dossier addDossier(Dossier dossier);
    Dossier updateDossier(Dossier dossier);
    void deleteDossier(Long id);
    Dossier getDossier(Long id);
    List<Dossier> getAllDossier();
}
