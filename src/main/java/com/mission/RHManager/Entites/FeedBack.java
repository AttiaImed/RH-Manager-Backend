package com.mission.RHManager.Entites;

import com.mission.RHManager.Entites.Enum.TypeFeedBack;
import jakarta.persistence.*;
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
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String feedBack;


     @Enumerated(EnumType.STRING)
    TypeFeedBack typeFeedBack;
}
