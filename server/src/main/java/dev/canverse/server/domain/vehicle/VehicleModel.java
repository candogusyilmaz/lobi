package dev.canverse.server.domain.vehicle;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Entity
@Table(name = "vehicle_models")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VehicleBrand brand;

    @Column(nullable = false, length = 63)
    private String name;

    protected VehicleModel() {
    }

    public VehicleModel(VehicleBrand brand, String name) {
        setBrand(brand);
        setName(name);
    }

    public void setBrand(VehicleBrand brand) {
        if (brand == null || brand.getId() == null)
            throw new IllegalArgumentException("Brand cannot be null");

        this.brand = brand;
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
