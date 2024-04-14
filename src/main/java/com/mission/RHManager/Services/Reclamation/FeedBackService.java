package com.mission.RHManager.Services.Reclamation;

import com.mission.RHManager.Entites.FeedBack;

import java.util.List;

public interface FeedBackService {

    FeedBack addFeedback(FeedBack feedBack);
    FeedBack updateFeedBack(FeedBack feedBack);
    void deleteFeedBack(Long id);
    FeedBack getFeedBack(Long id);
    List<FeedBack> getAllFeedBack();

}
