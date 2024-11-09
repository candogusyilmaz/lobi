package dev.canverse.server.domain.vehicle;

import dev.canverse.server.domain.reservation.Reservable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

@Getter
@Entity
@Table(name = "vehicles")
public class Vehicle extends Reservable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VehicleModel model;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VehicleLocation location;

    @Setter
    private Integer year;

    @Column(nullable = false, length = 31)
    private String licensePlate;

    protected Vehicle() {
    }

    public Vehicle(VehicleModel model, VehicleLocation location, Integer year, String licensePlate) {
        setBrand(model);
        setLocation(location);
        setYear(year);
        setLicensePlate(licensePlate);
    }

    public void setBrand(VehicleModel model) {
        if (model == null || model.getId() == null)
            throw new IllegalArgumentException("Brand cannot be null");

        this.model = model;
    }

    public void setLocation(VehicleLocation location) {
        if (location == null || location.getId() == null)
            throw new IllegalArgumentException("Location cannot be null");

        this.location = location;
    }

    public void setLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.isEmpty())
            throw new IllegalArgumentException("License plate cannot be blank");

        licensePlate = StringUtils.upperCase(licensePlate).toUpperCase(Locale.ENGLISH);

        if (licensePlate.length() < 3 || licensePlate.length() > 31)
            throw new IllegalArgumentException("License plate must be between 3 and 31 characters");

        this.licensePlate = licensePlate;
    }
}
