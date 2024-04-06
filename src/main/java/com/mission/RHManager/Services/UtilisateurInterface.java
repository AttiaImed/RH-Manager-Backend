package com.mission.RHManager.Services;

import com.mission.RHManager.Entites.Utilisateur;
import lombok.AllArgsConstructor;

import java.util.List;

public interface UtilisateurInterface {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateurById(Long id);
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);
    void deleteUtilisateur(Long id);
}
