package com.mission.RHManager.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SousTache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String text;
    boolean isChecked; // Changed column name to avoid conflict with SQL reserved keyword
    Date updated;
    @OneToOne
    Utilisateur user;
    @JsonIgnore
    @ManyToOne
    Tache tache;
}
