package com.mission.RHManager.Repositories;


import com.mission.RHManager.Entites.SousTache;
import com.mission.RHManager.Entites.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findTacheByDossierId(Long id);
    //create function getTacheByProjectIdAndUserId
    List<Tache> findTacheByIdAndMembersId(Long dossierId, Long memberId);
    List<Tache> findTacheByMembersId(Long id);

    //List<List<SousTache>> findvalidatedChecklistsByUser(long userId);
}
