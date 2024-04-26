package com.mission.RHManager.Repositories;

import com.mission.RHManager.Entites.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
    Optional<FileEntity> findByUserId(Long userId);
}
