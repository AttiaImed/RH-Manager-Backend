package com.mission.RHManager.Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String projectName;
    String projectDesc;
    @ManyToOne
    Equipe team;
    String status;
    LocalDateTime startDate;
    Date endDate;
    @OneToMany(mappedBy = "projet")
    List<Dossier> dossiers = new ArrayList<>();
}
