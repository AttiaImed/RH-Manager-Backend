package com.mission.RHManager.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mission.RHManager.Entites.Enum.Departement;
import com.mission.RHManager.Entites.Enum.Domaine;
import com.mission.RHManager.Services.UtilisateurService;
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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id;
     String nom ;
     String status;
     String domaine;
     Departement departement;
     @JsonIgnore
     @OneToMany
    List<Projet> projets = new ArrayList<>();
     @OneToMany
     List<Utilisateur> membres = new ArrayList<>();
     @OneToOne
     Utilisateur chef;
    public void addProject(Projet project) {
        if (this.projets.isEmpty()) {
            this.projets.add(0, project);
        } else {
            this.projets.add(project);
        }
    }
    public void removeProject(Projet projet) {
        projets.remove(projet);
    }

        public void addMembre (Utilisateur membre)
        {
            this.membres.add(membre);
        }
    public void removeMembre(Utilisateur utilisateur) {
        membres.remove(utilisateur);
    }

}
