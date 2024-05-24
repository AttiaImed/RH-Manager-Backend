package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Equipe;
import com.mission.RHManager.Entites.EquipeHistorique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeHistoriqueRepository extends JpaRepository<EquipeHistorique, Long> {
    List<EquipeHistorique> findByEquipe(Equipe team);
}
