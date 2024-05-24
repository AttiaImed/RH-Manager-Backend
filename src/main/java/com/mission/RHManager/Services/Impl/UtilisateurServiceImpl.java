package com.mission.RHManager.Services.Impl;

import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Repositories.UtilisateurRepository;
import com.mission.RHManager.Services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.orElse(null);
    }
    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmail(email);
        return utilisateurOptional.orElse(null);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = optionalUtilisateur.get();
            existingUtilisateur.setNom(utilisateur.getNom());
            existingUtilisateur.setPrenom(utilisateur.getPrenom());
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setPassword(utilisateur.getPassword());
            existingUtilisateur.setPoste(utilisateur.getPoste());
            existingUtilisateur.setStatus(utilisateur.isStatus());
             // You might want to handle updating other fields like 'presences' here

            return utilisateurRepository.save(existingUtilisateur);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public long countUtilisateur() {
     return utilisateurRepository.count();
    }
}
//get the current loogin user
//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if(principal instanceof UserDetails){
//UserDetails userDetails = (UserDetails) principal;
//String username = userDetails.getUsername();
//// use username or userDetails as needed
//        }else{
//String username = principal.toString();
//// handle cases where the principal is not an instance of UserDetails
//        }