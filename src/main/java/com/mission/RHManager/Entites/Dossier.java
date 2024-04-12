package com.mission.RHManager.Entites;

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
     int num;
     String nom;
     @OneToMany(mappedBy = "dossier")
     List<Tache> taches = new ArrayList<Tache>();
     @ManyToOne
     Projet projet;
     String goals;
     String status;
    public void addTask(Tache task) {
        if(this.taches.isEmpty()) {
            this.taches.add(0, task);
        }else {
            this.taches.add(task);
        }
    }
}
