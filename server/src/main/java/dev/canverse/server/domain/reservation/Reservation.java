package dev.canverse.server.domain.reservation;

import dev.canverse.server.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "reservations")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Reservation {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservable_id")
    private Reservable reservable;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User user;

    @Getter
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @Getter
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> metadata = new HashMap<>();

    public Reservation() {
    }

    public Reservation(Reservable reservable, User user, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        setReservable(reservable);
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

    protected void setReservable(Reservable reservable) {
        if (reservable == null || reservable.getId() == null)
            throw new IllegalArgumentException("Reservable must not be null");

        this.reservable = reservable;
    }

    public void setUser(User user) {
        if (user == null || user.getId() == null)
            throw new IllegalArgumentException("User must not be null");

        this.user = user;
    }
}
