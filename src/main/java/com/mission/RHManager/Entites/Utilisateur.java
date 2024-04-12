package com.mission.RHManager.Entites;

import com.mission.RHManager.Entites.Enum.TypeUser;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

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
     String login;
     String password;
     boolean status;
     @Enumerated(EnumType.STRING)
     TypeUser type;

}
