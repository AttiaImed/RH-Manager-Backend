package com.mission.RHManager.Repositories;


import com.mission.RHManager.Entites.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
