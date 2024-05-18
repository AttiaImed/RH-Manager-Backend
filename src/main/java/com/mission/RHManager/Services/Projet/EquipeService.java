package com.mission.RHManager.Services.Projet;

import com.mission.RHManager.Entites.Equipe;
import com.mission.RHManager.Entites.EquipeHistorique;
import com.mission.RHManager.Entites.Projet;
import com.mission.RHManager.Entites.Utilisateur;

import java.util.List;

public interface EquipeService {
    public Equipe addEquipe(Equipe equipe);
    public void updateEquipe(Long teamId,Equipe team);
    public void deleteEquipe(Long id);
    public Equipe getEquipe(Long id);
    public List<Equipe> getAllEquipe();
    public List<Equipe> getTeamsByUserId(Long userId);
    public List<Utilisateur> getMembres(Long teamId);
    public Utilisateur getManager(Long managerId);
    public List<Projet> getProjets(Long teamId);
    public List<Utilisateur> getAllUsers();
    public List<Projet> getAllProjects();
    void AddUser(Long teamId, Long userId);
    void deleteUser(Long teamId, Long userId);
    void AddProject(Long teamId, Long userId);
    void deleteProject(Long teamId, Long userId);

    void addEquipeHistorique(Long teamId, EquipeHistorique equipeHestorique);
    public List<EquipeHistorique> getAllTeamHistory (Long idEquipe);

}
