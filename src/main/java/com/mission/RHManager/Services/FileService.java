package com.mission.RHManager.Services;

import com.mission.RHManager.Entites.FileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileEntity storeFile(MultipartFile file, long userId);
    FileEntity getFile(long userId);
}
