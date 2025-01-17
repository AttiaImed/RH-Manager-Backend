package com.mission.RHManager.Services.Impl.Project;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Repositories.DossierRepository;
import com.mission.RHManager.Services.Projet.DossierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DossierServiceImpl implements DossierService {

    private final DossierRepository dossierRepository;

    @Override
    public Dossier addDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public Dossier updateDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public void deleteDossier(Long id) {
        dossierRepository.deleteById(id);
    }

    @Override
    public Dossier getDossier(Long id) {
        return dossierRepository.findById(id).get();
    }

    @Override
    public List<Dossier> getAllDossier() {
        List<Dossier> dossiers = dossierRepository.findAll();
        if(dossiers.isEmpty()) {
            throw new RuntimeException("No dossiers found");
        }
        return dossiers;
    }
}
