package com.mission.RHManager.Controller;


import com.mission.RHManager.Entites.Message;
import com.mission.RHManager.Entites.Presence;
import com.mission.RHManager.Entites.Response.SendMessageRequest;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final EmailService emailService;

    @PostMapping
    public Message sendMessassge(@RequestBody Message message) {
        message.setTimestamp(System.currentTimeMillis());
        return emailService.saveMessage(message);
    }

    @GetMapping
    public List<Message> getMessages() {
        return emailService.getAllMessages();
    }

    @GetMapping("/messages")
    public List<Message> getMessagesByUserIds(
            @RequestParam("senderId") Long senderId,
            @RequestParam("receiverId") Long receiverId) {
        return emailService.getMessagesByUserIds(senderId, receiverId);
    }

    @PostMapping("/send-message")
    public Message sendMessageBetweenUsers(@RequestBody SendMessageRequest request) {
        Long senderId = request.getSenderId();
        Long receiverId = request.getReceiverId();
        String content = request.getContent();

        return emailService.sendMessage(senderId, receiverId, content);
    }
}
