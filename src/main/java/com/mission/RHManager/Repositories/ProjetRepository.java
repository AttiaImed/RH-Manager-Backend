package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
