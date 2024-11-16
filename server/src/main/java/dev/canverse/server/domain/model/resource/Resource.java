package dev.canverse.server.domain.model.resource;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "resources", schema = "resource")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Resource {
    @Id
    @Getter

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private boolean active = true;
}
