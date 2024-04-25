package com.mission.RHManager.Services.Impl.Project;

import com.mission.RHManager.Entites.Conge;
import com.mission.RHManager.Repositories.CongeRepository;
import com.mission.RHManager.Services.Projet.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongeServiceImpl implements CongeService {
    @Autowired
    private CongeRepository congeRepository;

    @Override
    public Conge saveConge(Conge conge) {
        return congeRepository.save(conge);
    }

    @Override
    public Conge getCongeById(Long id) {
        Optional<Conge> conge = congeRepository.findById(id);
        return conge.orElse(null);
    }

    @Override
    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    @Override
    public Conge updateConge(Long id, Conge conge) {
        Optional<Conge> congeToUpdate = congeRepository.findById(id);
        if (congeToUpdate.isPresent()) {
            Conge updatedConge = congeToUpdate.get();
            updatedConge.setDateDebut(conge.getDateDebut());
            updatedConge.setDateFin(conge.getDateFin());
            updatedConge.setType(conge.getType());
            updatedConge.setDescription(conge.getDescription());
            return congeRepository.save(updatedConge);
        }
        return null;
    }

    @Override
    public void deleteConge(Long id) {
        congeRepository.deleteById(id);
    }

    @Override
    public int getCasualLeaveCount() {
        return congeRepository.countCasualLeave();
    }

    @Override
    public int getSickLeaveCount() {
        return congeRepository.countSickLeave();
    }

    @Override
    public int getPersonalDaysCount() {
        return congeRepository.countPersonalDays();
    }
}
