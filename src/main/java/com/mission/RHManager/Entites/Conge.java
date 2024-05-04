package com.mission.RHManager.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}
