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
    private Long idTache;

    private String nom;
    private String description;
    private TacheStatus status;
    private Long supervisorId;
    private int progress;
    private boolean priority;
    private String comments;
    private LocalDate dateDebut;
    private LocalDate dateFin;

}
