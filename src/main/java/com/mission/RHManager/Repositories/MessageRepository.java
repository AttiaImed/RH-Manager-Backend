package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.Conge;
import com.mission.RHManager.Entites.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message, Long> {}