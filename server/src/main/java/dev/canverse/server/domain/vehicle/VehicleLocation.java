package dev.canverse.server.domain.vehicle;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Entity
@Table(name = "vehicle_locations")
public class VehicleLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 63)
    private String name;

    protected VehicleLocation() {
    }

    public VehicleLocation(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");

        name = StringUtils.normalizeSpace(name.trim());

        if (name.length() < 2 || name.length() > 63)
            throw new IllegalArgumentException("Name must be between 2 and 63 characters");

        this.name = name;
    }
}
