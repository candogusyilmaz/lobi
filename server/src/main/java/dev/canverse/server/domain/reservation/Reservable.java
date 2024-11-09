package dev.canverse.server.domain.reservation;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "reservables")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
public abstract class Reservable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean active = true;
}
