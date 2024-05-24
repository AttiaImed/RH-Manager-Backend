package com.mission.RHManager.Entites;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter

public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    boolean presence;
    private LocalDate date;

    @ManyToOne
     Utilisateur utilisateur;

}
