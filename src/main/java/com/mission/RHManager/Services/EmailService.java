package com.mission.RHManager.Services;
import com.mission.RHManager.Entites.Message;
import com.mission.RHManager.Entites.Utilisateur;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EmailService {
    void sendSimpleEmail(String to, String subject, String text);
    void sendEmailWithTemplate(Utilisateur user);
    List<Message> getAllMessages();
    Message saveMessage(Message message);
}
