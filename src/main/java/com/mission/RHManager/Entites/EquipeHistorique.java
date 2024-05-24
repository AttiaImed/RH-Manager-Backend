package com.mission.RHManager.Entites;

import com.mission.RHManager.Entites.Enum.TypeHistoriqueEquipe;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipeHistorique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    TypeHistoriqueEquipe type;
    String action;
    Date date;
    String acteur;

    @ManyToOne
    Equipe equipe;

}
