package pl.jaroslaw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Statistics {
    @Id
    @GeneratedValue
    private Long id;
    private int countAllGames;
    private int registrationPlayers;
}
