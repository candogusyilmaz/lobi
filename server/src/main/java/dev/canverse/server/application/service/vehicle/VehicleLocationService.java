package dev.canverse.server.application.service.vehicle;

import dev.canverse.server.application.dto.vehicle.VehicleLocationCreate;
import dev.canverse.server.domain.model.lookup.VehicleLocation;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleLocationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleLocationService {
    private final VehicleLocationJpaRepository vehicleLocationJpaRepository;

    public VehicleLocationCreate.Response createVehicleLocation(VehicleLocationCreate.Body body) {
        var location = new VehicleLocation(body.name());

        if (vehicleLocationJpaRepository.existsByName(location.getName()))
            throw new IllegalArgumentException("Vehicle location already exists");

        vehicleLocationJpaRepository.save(location);

        return new VehicleLocationCreate.Response(location.getId().toString(), location.getName());
    }
}
