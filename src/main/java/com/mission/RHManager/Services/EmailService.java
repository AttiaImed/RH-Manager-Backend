package com.mission.RHManager.Services;
import com.mission.RHManager.Entites.Utilisateur;

public interface EmailService {
    void sendSimpleEmail(String to, String subject, String text);
    void sendEmailWithTemplate(Utilisateur user);
}
