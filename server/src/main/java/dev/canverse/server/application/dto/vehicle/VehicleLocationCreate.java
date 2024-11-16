package dev.canverse.server.application.dto.vehicle;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public final class VehicleLocationCreate {
    public record Body(@NotBlank @Length(min = 2, max = 63) String name) {
    }

    public record Response(String id, String name) {
    }
}
