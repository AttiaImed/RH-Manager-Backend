package com.mission.RHManager.Services.Projet;

    import com.mission.RHManager.Entites.Conge;
    import com.mission.RHManager.Entites.Enum.ApprovalStatus;

    import java.util.List;

public interface CongeService {
    Conge saveConge(Conge conge);
    Conge getCongeById(Long id);
    List<Conge> getAllConges();
    Conge updateConge(Long id, Conge conge);
    void deleteConge(Long id);
    int getCasualLeaveCount();
    int getSickLeaveCount();
    int getPersonalDaysCount();

    Conge updateApprovalStatus(Long id, ApprovalStatus status);



}
