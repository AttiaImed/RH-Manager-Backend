package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CongeRepository extends JpaRepository<Conge, Long> {
    @Query("SELECT COUNT(c) FROM Conge c WHERE c.type = 'Casual Leave'")
    int countCasualLeave();

    @Query("SELECT COUNT(c) FROM Conge c WHERE c.type = 'Sick Leave'")
    int countSickLeave();

    @Query("SELECT COUNT(c) FROM Conge c WHERE c.type = 'Personal Leave'")
    int countPersonalDays();
}
