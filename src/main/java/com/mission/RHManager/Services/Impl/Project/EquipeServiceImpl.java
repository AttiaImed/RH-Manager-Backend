package com.mission.RHManager.Services.Impl.Project;

import com.mission.RHManager.Entites.Equipe;
import com.mission.RHManager.Repositories.EquipeRepository;
import com.mission.RHManager.Services.Projet.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository teamRepository;
    @Override
    public Equipe addEquipe(Equipe equipe) {
        return teamRepository.save(equipe);
    }

    @Override
    public void updateEquipe(Long teamId,Equipe team) {
        Equipe updateTeam = teamRepository.findById(teamId).get();
        updateTeam.setNom(team.getNom());
        updateTeam.setStatus(team.getStatus());
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
    public void addOrRemoveUser(Long teamId, String userId) {
        Equipe team = teamRepository.findById(teamId).get();
        if (team != null) {
            if (team.getMembres().contains(userId)) {
                team.getMembres().remove(userId);
            } else {
                //team.getMembres().add(userId);
            }
            teamRepository.save(team); // Save the updated team
        }
    }

}
