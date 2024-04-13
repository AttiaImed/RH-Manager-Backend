package com.mission.RHManager.Services.Impl.Reclamation;

import com.mission.RHManager.Entites.FeedBack;
import com.mission.RHManager.Repositories.FeedBackRepository;
import com.mission.RHManager.Services.Reclamation.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    FeedBackRepository feedbackRepository;

    @Override
    public FeedBack addFeedback(FeedBack feedBack) {
        return feedbackRepository.save(feedBack);
    }

    @Override
    public FeedBack updateFeedBack(FeedBack feedBack) {
        return feedbackRepository.save(feedBack);
    }

    @Override
    public void deleteFeedBack(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public FeedBack getFeedBack(Long id) {
        return feedbackRepository.findById(id).get();
    }

    @Override
    public List<FeedBack> getAllFeedBack() {
        return feedbackRepository.findAll();
    }
}
