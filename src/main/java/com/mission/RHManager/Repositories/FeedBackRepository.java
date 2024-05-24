package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.FeedBack;
import com.mission.RHManager.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findByUtilisateurEmployeFeedBack(Utilisateur user);
}
