package com.mission.RHManager.Controller.Reclamation;


import com.mission.RHManager.Entites.FeedBack;
import com.mission.RHManager.Services.Reclamation.FeedBackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/FeedBack")
@AllArgsConstructor
public class FeedBackController {

    private final FeedBackService feedBackService;
    @PostMapping
    public ResponseEntity<FeedBack> addFeedback(@RequestBody FeedBack feedBack) {
        FeedBack FeedBackresponse = feedBackService.addFeedback(feedBack);
        return new ResponseEntity<FeedBack>(HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedback() {
        List<FeedBack> feedBacks = feedBackService.getAllFeedBack();
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FeedBack> updateFeedBack(@PathVariable long id, @RequestBody FeedBack feedBack) {
        feedBack.setId(id);
        feedBackService.updateFeedBack(feedBack);
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFeedBack(@PathVariable long id) {
        feedBackService.deleteFeedBack(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}