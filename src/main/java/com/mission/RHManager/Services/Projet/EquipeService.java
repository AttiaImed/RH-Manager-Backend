package com.mission.RHManager.Services.Projet;

import com.mission.RHManager.Entites.Equipe;

import java.util.List;

public interface EquipeService {
    public Equipe addEquipe(Equipe equipe);
    public void updateEquipe(Long teamId,Equipe team);
    public void deleteEquipe(Long id);
    public Equipe getEquipe(Long id);
    public List<Equipe> getAllEquipe();
    public List<Equipe> getTeamsByUserId(Long userId);
    public void addOrRemoveUser(Long teamId, String userId);

}
