package com.mission.RHManager.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reclamation;

    public Long getId() {
        return id;
    }

    public String getReclamation() {
        return reclamation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReclamation(String reclamation) {
        this.reclamation = reclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", reclamation='" + reclamation + '\'' +
                '}';
    }
}
