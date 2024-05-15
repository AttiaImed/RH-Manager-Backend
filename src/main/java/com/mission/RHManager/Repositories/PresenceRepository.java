package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Presence;
import com.mission.RHManager.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PresenceRepository extends JpaRepository<Presence, Long> {
        List<Presence> findByUtilisateurId(long utilisateurId);
        List<Presence> findByDate(LocalDate date);

}
