package com.mission.RHManager.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mission.RHManager.Entites.Enum.ApprovalStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    @NotBlank(message = "Date debut is required")
     String dateDebut;
    @NotBlank(message = "Date fin is required")
     String dateFin;
    @NotBlank(message = "Type is required")
     String type;
    @NotBlank(message = "Description is required")
     String description;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    Utilisateur utilisateur;

}
