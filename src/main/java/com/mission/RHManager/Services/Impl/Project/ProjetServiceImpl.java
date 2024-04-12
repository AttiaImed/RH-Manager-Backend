package com.mission.RHManager.Services.Impl.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Entites.Equipe;
import com.mission.RHManager.Entites.Projet;
import com.mission.RHManager.Entites.Tache;
import com.mission.RHManager.Repositories.DossierRepository;
import com.mission.RHManager.Repositories.EquipeRepository;
import com.mission.RHManager.Repositories.ProjetRepository;
import com.mission.RHManager.Services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {
    @Autowired
    private ProjetRepository projectRepository;
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private DossierRepository dossierRepository;
    @Override
    public Projet addProjet(Long teamId, Projet p) {
        Equipe team = equipeRepository.findById(teamId).get();
        LocalDateTime now = LocalDateTime.now();
        p.setStartDate(now);
        p.setTeam(team);
        Projet project = projectRepository.save(p);
        team.addProject(project);
        equipeRepository.save(team);
        return project;
    }


    @Override
    public Projet updateProjet(Long projectId,Projet project) {
        Projet projectToUpdate = projectRepository.findById(projectId).get();
        projectToUpdate.setProjectName(project.getProjectName());
        projectToUpdate.setProjectDesc(project.getProjectDesc());
        return projectRepository.save(projectToUpdate);

    }

    @Override
    public void deleteProjet(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public Projet getProjet(Long projectId) {
        return projectRepository.findById(projectId).get();
    }

    @Override
    public List<Projet> getAllProjet() {
        return projectRepository.findAll();
    }

    @Override
    public Projet addFolderToProject(Long id, Dossier folder) {
        //aaffecte projet lel dosiier
        Dossier dossier = dossierRepository.save(folder);
        Projet project = projectRepository.findById(id).get();
        project.getDossiers().add(folder);
        return null;

    }

    @Override
    public List<Projet> getProjectsByUserId(Long userId) {
        List<Projet> userProjects = new ArrayList<>();
        List<Projet> projects = projectRepository.findAll();
        for (Projet project : projects) {
            if (project.getTeam().getMembres().contains(userId)) {
                project.getTeam().setProjets(null);
                userProjects.add(project);
            }
        }

        return userProjects;
    }
    @Override
    public List<Projet> getProjectsBySupervisorId(Long supervisorId) {
        List<Projet> supervisorProjects = new ArrayList<>();
        List<Projet> projects = projectRepository.findAll();

        for (Projet project : projects) {
            List<Dossier> folders = project.getDossiers();
            for (Dossier folder : folders) {
                List<Tache> tasks = folder.getTaches();
                for (Tache task : tasks) {
                    if (task.getSuperviser().getId().equals(supervisorId)) {
                        project.getTeam().setProjets(null);
                        supervisorProjects.add(project);
                        break;
                    }
                }
            }
        }

        return supervisorProjects;
    }

}
