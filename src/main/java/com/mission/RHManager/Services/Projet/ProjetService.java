package com.mission.RHManager.Services.Projet;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Entites.Projet;

import java.util.List;

public interface ProjetService {
    //crud fonction

    public Projet addProjet(Long teamId, Projet p);

    public Projet updateProjet(Long projectId,Projet project);

    public void deleteProjet(Long projectId);
    public Projet getProjetById(Long projectId);

    public Projet getProjet(Long projectId);

    public List<Projet> getAllProjet();
    public List<Projet> getProjectsByUserId(Long userId);
    public Projet addFolderToProject(Long id, Dossier folder);
    public List<Projet> getProjectsBySupervisorId(Long supervisorId);

    Projet updateFolder(long id, Dossier f);
}
