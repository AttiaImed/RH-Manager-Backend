package com.mission.RHManager.Services.Reclamation;

import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Entites.FeedBack;
import com.mission.RHManager.Entites.Reclamation;

import java.util.List;

public interface FeedbackService {

    FeedBack addFeedback(FeedBack feedBack);
    FeedBack updateFeedBack(FeedBack feedBack);
    void deleteFeedBack(Long id);
    FeedBack getFeedBack(Long id);
    List<FeedBack> getAllFeedBack();

}
