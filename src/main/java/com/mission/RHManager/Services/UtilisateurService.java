package com.mission.RHManager.Services;

import com.mission.RHManager.Entites.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateurById(Long id);
    
    Utilisateur getUtilisateurByEmail(String email);

    List<Utilisateur> getAllUtilisateurs();
    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);
    void deleteUtilisateur(Long id);

    long countUtilisateur();
}
