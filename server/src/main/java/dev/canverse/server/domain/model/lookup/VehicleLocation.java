package dev.canverse.server.domain.model.lookup;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "vehicle_locations", schema = "lookup")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VehicleLocation {
    @Id
    @Getter
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false, length = 63)
    private String name;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private VehicleLocation parent;

    protected VehicleLocation() {
    }

    public VehicleLocation(String name) {
        setName(name);
    }

    public VehicleLocation(String name, VehicleLocation parent) {
        setName(name);
        setParent(parent);
    }

    public void setName(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");

        name = StringUtils.normalizeSpace(name.trim());

        if (name.length() < 2 || name.length() > 63)
            throw new IllegalArgumentException("Name must be between 2 and 63 characters");

        this.name = name;
    }

    public void setParent(VehicleLocation parent) {
        if (parent == null)
            throw new IllegalArgumentException("Parent cannot be null");

        if (this.equals(parent) || this.getId().equals(parent.getId()))
            throw new IllegalArgumentException("Parent cannot be self");

        this.parent = parent;
    }
}
