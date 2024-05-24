package com.mission.RHManager.Entites;

import com.mission.RHManager.Entites.Enum.ApprovalStatus;
import com.mission.RHManager.Entites.Enum.TypeReclamation;
import jakarta.persistence.*;
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
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate dateSoumission;
    LocalDate dateCloture;
    String titre;
    String description;
    @Enumerated(EnumType.STRING)
    TypeReclamation typeReclamation;
    @Enumerated(EnumType.STRING)
    ApprovalStatus status;

    @ManyToOne
    Utilisateur utilisateurReclamation;

}
