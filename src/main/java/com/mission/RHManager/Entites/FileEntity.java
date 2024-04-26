package com.mission.RHManager.Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String fileName;

    String fileType;
    @ManyToOne
    Utilisateur user;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    byte[] data;

}
