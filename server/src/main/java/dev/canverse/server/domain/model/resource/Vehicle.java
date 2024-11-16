package dev.canverse.server.domain.model.resource;

import dev.canverse.server.domain.model.lookup.VehicleLocation;
import dev.canverse.server.domain.model.lookup.VehicleModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "vehicles", schema = "resource")
public class Vehicle extends Resource {
    @Getter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VehicleModel model;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VehicleLocation location;

    @Getter
    @Setter
    private Integer year;

    @Getter
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
        this.model = Objects.requireNonNull(model, "Model cannot be null");
    }

    public void setLocation(VehicleLocation location) {
        this.location = Objects.requireNonNull(location, "Location cannot be null");
    }

    public void setLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.isEmpty())
            throw new IllegalArgumentException("License plate cannot be blank");

        licensePlate = StringUtils.upperCase(StringUtils.deleteWhitespace(licensePlate)).toUpperCase(Locale.ROOT);

        if (licensePlate.length() < 3 || licensePlate.length() > 31)
            throw new IllegalArgumentException("License plate must be between 3 and 31 characters");

        this.licensePlate = licensePlate;
    }
}
