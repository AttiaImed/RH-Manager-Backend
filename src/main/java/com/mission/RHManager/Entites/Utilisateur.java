package com.mission.RHManager.Entites;

import com.mission.RHManager.Entites.Enum.TypeUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String nom;
     String prenom;
     String email;
     String password;
     String role;
     Long idUtilisateur;

     TypeUser type;

     String login;
     String motDePasse;
     boolean status;

}
