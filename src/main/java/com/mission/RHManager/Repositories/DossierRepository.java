package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierRepository extends JpaRepository<Dossier, Long> {
}