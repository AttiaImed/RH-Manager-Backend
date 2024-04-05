package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Conge;
import com.mission.RHManager.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
}
