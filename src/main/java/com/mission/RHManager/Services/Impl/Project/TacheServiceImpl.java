package com.mission.RHManager.Services.Impl.Project;

import com.mission.RHManager.Entites.Tache;
import com.mission.RHManager.Repositories.TacheRepository;
import com.mission.RHManager.Services.Projet.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheServiceImpl implements TacheService {

    @Autowired
    TacheRepository tacheRepository;

    @Override
    public void addTache(Tache tache) {
        tacheRepository.save(tache);
    }

    @Override
    public void updateTache(Tache tache) {
        tacheRepository.save(tache);
    }

    @Override
    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }

    @Override
    public Optional<Tache> getTache(Long id) {
        return tacheRepository.findById(id);
    }

    @Override
    public List<Tache> getAllTache() {
        return tacheRepository.findAll();
    }
}
