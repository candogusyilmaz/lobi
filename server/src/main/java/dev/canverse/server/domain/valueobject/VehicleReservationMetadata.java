package dev.canverse.server.domain.valueobject;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class VehicleReservationMetadata {
    @PositiveOrZero
    private Integer startKilometers;

    @PositiveOrZero
    private Integer endKilometers;
}
