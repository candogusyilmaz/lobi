package dev.canverse.server.application.service.vehicle;

import dev.canverse.server.application.dto.vehicle.VehicleBrandCreate;
import dev.canverse.server.domain.model.lookup.VehicleBrand;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleBrandJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleBrandService {
    private final VehicleBrandJpaRepository vehicleBrandJpaRepository;

    public VehicleBrandCreate.Response createVehicleBrand(VehicleBrandCreate.Body body) {
        var brand = new VehicleBrand(body.name());

        vehicleBrandJpaRepository.save(brand);

        return new VehicleBrandCreate.Response(brand.getId(), brand.getName());
    }
}
