package com.mission.RHManager.Entites;

import com.mission.RHManager.Entites.Enum.TacheStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idTache;

     String nom;
     String description;
     TacheStatus status;
     Long supervisorId;
     int progress;
     boolean priority;
     String comments;
     LocalDate dateDebut;
     LocalDate dateFin;

}
