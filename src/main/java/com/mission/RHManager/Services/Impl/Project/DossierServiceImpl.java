package com.mission.RHManager.Services.Impl.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Repositories.DossierRepository;
import com.mission.RHManager.Services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierServiceImpl implements DossierService {

    @Autowired
    DossierRepository dossierRepository;

    @Override
    public void addDossier(Dossier dossier) {
        dossierRepository.save(dossier);
    }

    @Override
    public void updateDossier(Dossier dossier) {
        dossierRepository.save(dossier);
    }

    @Override
    public void deleteDossier(Long id) {
        dossierRepository.deleteById(id);
    }

    @Override
    public Optional<Dossier> getDossier(Long id) {
        return dossierRepository.findById(id);
    }

    @Override
    public List<Dossier> getAllDossier() {
        return dossierRepository.findAll();
    }
}
