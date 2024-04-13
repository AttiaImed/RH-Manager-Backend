package com.mission.RHManager.Controller.Reclamation;


import com.mission.RHManager.Entites.Dossier;
import com.mission.RHManager.Entites.FeedBack;
import com.mission.RHManager.Entites.Reclamation;
import com.mission.RHManager.Services.Reclamation.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Feedback")
@AllArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedback() {
        List<FeedBack> feedBacks = feedbackService.getAllFeedBack();
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedBack> addFeedback(@RequestBody FeedBack feedBack) {
        FeedBack FeedBackresponse = feedbackService.addFeedback(feedBack);
        return new ResponseEntity<FeedBack>(HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<FeedBack> updateFeedBack(@PathVariable Long id, @RequestBody FeedBack feedBack) {
        feedBack.setId(id);
        feedbackService.updateFeedBack(feedBack);
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFeedBack(@PathVariable Long id) {
        feedbackService.deleteFeedBack(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}