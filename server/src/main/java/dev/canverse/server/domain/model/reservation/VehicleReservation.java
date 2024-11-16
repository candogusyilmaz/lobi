package dev.canverse.server.domain.model.reservation;

import dev.canverse.server.domain.model.resource.Vehicle;
import dev.canverse.server.domain.model.user.User;
import dev.canverse.server.domain.valueobject.VehicleReservationMetadata;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_reservations", schema = "reservation")
public class VehicleReservation extends Reservation<Vehicle> {
    @Getter
    @Embedded
    private VehicleReservationMetadata metadata = new VehicleReservationMetadata();

    protected VehicleReservation() {
    }

    public VehicleReservation(Vehicle vehicle, User user, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        super(vehicle, user, startDateTime, endDateTime);
    }
}
