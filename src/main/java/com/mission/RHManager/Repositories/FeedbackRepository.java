package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Conge;
import com.mission.RHManager.Entites.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {
}
