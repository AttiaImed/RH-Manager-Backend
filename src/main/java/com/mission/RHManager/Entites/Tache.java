package com.mission.RHManager.Entites;

import com.mission.RHManager.Entites.Enum.TacheStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    long id;

     String nom;
     String description;
     @Enumerated(EnumType.STRING)
     TacheStatus status;
     int progress;
     boolean priority;
     String comments;
     LocalDate dateDebut;
     LocalDate dateFin;
     @ManyToOne
     Dossier dossier;
     @OneToOne
     Utilisateur superviser;
     @OneToMany
     List<Utilisateur> members;
     @OneToMany(mappedBy = "tache")
     List<SousTache> sousTaches = new ArrayList<SousTache>();
}
