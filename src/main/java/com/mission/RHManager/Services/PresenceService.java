package com.mission.RHManager.Services;

import com.mission.RHManager.Entites.FeedBack;
import com.mission.RHManager.Entites.Presence;
import com.mission.RHManager.Entites.Utilisateur;

import java.util.List;

public interface PresenceService {

    Presence addPresence(Presence presence);
    Presence updatePresence(Presence presence);
    List<Utilisateur> getAllPresence();
    Presence getPresenceById(long id);
    List<Presence> getPresenceByUtilisateurId(long utilisateurId);

}

