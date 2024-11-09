package dev.canverse.server.domain.vehicle;

import dev.canverse.server.domain.reservation.Reservation;
import dev.canverse.server.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_reservations")
public class VehicleReservation extends Reservation {

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservable_id", nullable = false)
    private Vehicle vehicle;

    protected VehicleReservation() {
    }

    public VehicleReservation(Vehicle vehicle, User user, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        super(vehicle, user, startDateTime, endDateTime);
        this.vehicle = vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.setReservable(vehicle);
        this.vehicle = vehicle;
    }

    public int getStartKilometers() {
        return (int) this.getMetadata().get("startKilometers");
    }

    public void setStartKilometers(int startKilometers) {
        if (startKilometers < 0)
            throw new IllegalArgumentException("Start kilometers must not be negative");

        this.getMetadata().put("startKilometers", startKilometers);
    }

    public int getEndKilometers() {
        return (int) this.getMetadata().get("endKilometers");
    }

    public void setEndKilometers(int endKilometers) {
        if (endKilometers < 0)
            throw new IllegalArgumentException("End kilometers must not be negative");

        this.getMetadata().put("endKilometers", endKilometers);
    }
}
