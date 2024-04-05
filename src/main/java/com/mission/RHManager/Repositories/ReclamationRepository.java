package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Conge;
import com.mission.RHManager.Entites.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}
