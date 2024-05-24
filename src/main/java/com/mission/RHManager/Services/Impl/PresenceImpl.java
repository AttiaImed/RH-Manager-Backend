package com.mission.RHManager.Services.Impl;

import com.mission.RHManager.Entites.Presence;
import com.mission.RHManager.Repositories.PresenceRepository;
import com.mission.RHManager.Services.PresenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Presence> getAllPresence() {
        return presenceRepository.findAll();
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
