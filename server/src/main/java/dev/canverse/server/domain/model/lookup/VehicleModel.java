package dev.canverse.server.domain.model.lookup;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Entity
@Table(name = "vehicle_models", uniqueConstraints = {@UniqueConstraint(name = "unique_by_brand_id_and_name", columnNames = {"brand_id", "name"})}, schema = "lookup")
public class VehicleModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VehicleBrand brand;

    @Getter
    @Column(nullable = false, length = 63)
    private String name;

    protected VehicleModel() {
    }

    public VehicleModel(VehicleBrand brand, String name) {
        setBrand(brand);
        setName(name);
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = Objects.requireNonNull(brand, "Brand cannot be null");
    }

    public void setName(String name) {
        if (StringUtils.isBlank(name)) throw new IllegalArgumentException("Name cannot be blank");

        name = StringUtils.normalizeSpace(name.trim());

        if (name.length() < 2 || name.length() > 63)
            throw new IllegalArgumentException("Name must be between 2 and 63 characters");

        this.name = name;
    }
}
