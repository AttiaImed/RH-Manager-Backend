package com.mission.RHManager.Services.Impl;

import com.mission.RHManager.Entites.Presence;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Repositories.PresenceRepository;
import com.mission.RHManager.Services.PresenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PresenceImpl implements PresenceService {
    PresenceRepository presenceRepository;

    @Override
    public Presence addPresence(Presence presence) {
        return presenceRepository.save(presence);

    }

    @Override
    public Presence updatePresence(Presence presence) {
        return presenceRepository.save(presence);
    }

    @Override
    public List<Utilisateur> getAllPresence() {
        LocalDate today = LocalDate.now();
        List<Presence> todayPresence = presenceRepository.findAll().stream()
                .filter(presence -> presence.isPresence() && presence.getDate().isEqual(today))
                .collect(Collectors.toList());

        Set<Utilisateur> uniqueUsers = todayPresence.stream()
                .map(Presence::getUtilisateur)
                .collect(Collectors.toSet());

        return List.copyOf(uniqueUsers);
    }


    public Presence getPresenceById(long id) {
        return presenceRepository.findById((id)).orElse(null);
    }

    @Override
    public List<Presence> getPresenceByUtilisateurId(long utilisateurId) {
        return presenceRepository.findByUtilisateurId(utilisateurId);
        //LocalDate l = LocalDate.now();
        //return presenceRepository.findByDate(l);

    }

}
