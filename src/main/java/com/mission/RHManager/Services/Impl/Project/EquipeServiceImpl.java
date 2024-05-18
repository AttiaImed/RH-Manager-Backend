package com.mission.RHManager.Services.Impl.Project;

import com.mission.RHManager.Entites.Equipe;
import com.mission.RHManager.Entites.EquipeHistorique;
import com.mission.RHManager.Entites.Projet;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Repositories.EquipeHistoriqueRepository;
import com.mission.RHManager.Repositories.EquipeRepository;
import com.mission.RHManager.Repositories.ProjetRepository;
import com.mission.RHManager.Repositories.UtilisateurRepository;
import com.mission.RHManager.Services.Projet.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository teamRepository;

    private final UtilisateurRepository utilisateurRepository;

    private final ProjetRepository projectRepository;
    private final EquipeHistoriqueRepository equipeHistoriqueRepository;

    private final ProjetServiceImpl projetService;
    @Override
    public Equipe addEquipe(Equipe equipe) {
        return teamRepository.save(equipe);
    }

    @Override
    public void updateEquipe(Long teamId,Equipe team) {
        Equipe updateTeam = teamRepository.findById(teamId).get();
        updateTeam.setNom(team.getNom());
        updateTeam.setChef(team.getChef());
        updateTeam.setDomaine(team.getDomaine());
        teamRepository.save(updateTeam); // Save the updated team
    }
        @Override
    public void deleteEquipe(Long id) {
        Equipe team = teamRepository.findById(id).get();
        team.getProjets().forEach((el)->{
            el.setTeam(null);
        });
        teamRepository.deleteById(id);
    }


    @Override
    public Equipe getEquipe(Long id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public List<Equipe> getAllEquipe() {
        List<Equipe> teams = teamRepository.findAll();
        for (Equipe team : teams) {
            team.getProjets().forEach((el)->{
                el.setTeam(null);
            });
        }
        return teams;
    }
    @Override
    public List<Equipe> getTeamsByUserId(Long userId) {
        List<Equipe> matchingTeams = new ArrayList<>();
        List<Equipe> teams = teamRepository.findAll();
        for (Equipe team : teams) {
            if (team.getMembres().contains(userId)) {
                team.getProjets().forEach((el)->{
                    el.setTeam(null);
                });
                matchingTeams.add(team);
            }
        }

        return matchingTeams;
    }

    @Override
    public List<Utilisateur> getMembres(Long teamId) {
        return teamRepository.findById(teamId).get().getMembres();
    }

    @Override
    public Utilisateur getManager(Long Id) {
        Equipe team = teamRepository.findById(Id).get();
        return utilisateurRepository.findById(team.getChef().getId()).get();
    }

    @Override
    public List<Projet> getProjets(Long teamId) {
        return teamRepository.findById(teamId).get().getProjets();
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<Projet> getAllProjects() {
        return projectRepository.findAll();
    }


    @Override
    public void AddUser(Long teamId, Long userId) {
       Equipe team= teamRepository.findById(teamId).get();
       team.addMembre(utilisateurRepository.findById(userId).get());
        System.out.println("this is the user"+utilisateurRepository.findById(userId).get());
         teamRepository.save(team);
    }

    @Override
    public void deleteUser(Long teamId, Long userId) {
        Equipe team= teamRepository.findById(teamId).get();
        team.removeMembre(utilisateurRepository.findById(userId).get());
        teamRepository.save(team);
    }
    @Override
    public void AddProject(Long teamId, Long projectId) {
        Equipe team= teamRepository.findById(teamId).get();
        team.addProject(projectRepository.findById(projectId).get());
        teamRepository.save(team);
    }

    @Override
    public void deleteProject(Long teamId, Long projectId) {
        Equipe team= teamRepository.findById(teamId).get();
        team.removeProject(projectRepository.findById(projectId).get());
        teamRepository.save(team);
    }

    @Override
    public void addEquipeHistorique(Long teamId, EquipeHistorique equipeHestorique) {
        equipeHestorique.setEquipe(teamRepository.findById(teamId).get());
        equipeHistoriqueRepository.save(equipeHestorique);
    }

    @Override
    public List<EquipeHistorique> getAllTeamHistory(Long teamId) {
        Equipe team= teamRepository.findById(teamId).get();
        return equipeHistoriqueRepository.findByEquipe(team);
    }

}
