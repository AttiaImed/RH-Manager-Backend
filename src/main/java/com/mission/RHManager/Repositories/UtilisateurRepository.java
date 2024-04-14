package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Conge;
import com.mission.RHManager.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
}
