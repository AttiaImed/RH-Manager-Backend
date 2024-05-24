package com.mission.RHManager.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id;
     String nom;
     @OneToMany(mappedBy = "dossier")
     List<Tache> taches = new ArrayList<Tache>();
     @JsonIgnore
     @ManyToOne
     Projet projet;
     String goals;
     String status;
     int progress;
}
