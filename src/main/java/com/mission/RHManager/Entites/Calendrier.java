package com.mission.RHManager.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Calendrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idCalendrier;


     int annee;

   /**  List<String> joursFeries;
     List<String> evenementsSpeciaux;
     List<Conge> congesPlanifies;**/

     int joursOuvrables;

}
