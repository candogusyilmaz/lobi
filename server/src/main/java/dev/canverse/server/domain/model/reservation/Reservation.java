package dev.canverse.server.domain.model.reservation;

import dev.canverse.server.domain.model.resource.Resource;
import dev.canverse.server.domain.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "reservations", schema = "reservation")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Reservation<T extends Resource> {
    @Id
    @Getter

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Resource.class)
    private T resource;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User user;

    @Getter
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @Getter
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    public Reservation() {
    }

    public Reservation(T resource, User user, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        setResource(resource);
        //setUser(user);
        setPeriod(startDateTime, endDateTime);
    }

    public void setPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime == null || endDateTime == null)
            throw new IllegalArgumentException("Start date time and end date time must not be null");

        if (startDateTime.isAfter(endDateTime))
            throw new IllegalArgumentException("Start date time must be before end date time");

        this.startDateTime = startDateTime.truncatedTo(ChronoUnit.MINUTES);
        this.endDateTime = endDateTime.truncatedTo(ChronoUnit.MINUTES);
    }

    public void setResource(T resource) {
        if (resource == null || resource.getId() == null)
            throw new IllegalArgumentException("Reservable must not be null");

        if (this.resource != null && resource.getId().equals(this.resource.getId()))
            throw new IllegalArgumentException("Reservable must be different from the current one");

        this.resource = resource;
    }

    public void setUser(User user) {
        if (user == null || user.getId() == null)
            throw new IllegalArgumentException("User must not be null");

        this.user = user;
    }
}
