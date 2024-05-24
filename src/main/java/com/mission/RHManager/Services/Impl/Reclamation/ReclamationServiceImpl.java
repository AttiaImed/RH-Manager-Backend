package com.mission.RHManager.Services.Impl.Reclamation;

import com.mission.RHManager.Entites.Enum.ApprovalStatus;
import com.mission.RHManager.Entites.Reclamation;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Repositories.ReclamationRepository;
import com.mission.RHManager.Services.Reclamation.ReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReclamationServiceImpl implements ReclamationService {
    ReclamationRepository reclamationRepository;
    @Override
    public Reclamation saveReclamation(Reclamation reclamation) {
        reclamation.setStatus(ApprovalStatus.PENDING);
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation getReclamationById(Long id) {
        Optional<Reclamation> reclamationOptional = reclamationRepository.findById(id);
        return reclamationOptional.orElse(null);
    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation updateReclamation( Reclamation reclamation) {
        reclamationRepository.save(reclamation);
        return reclamation;
    }

    @Override
    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }

}
