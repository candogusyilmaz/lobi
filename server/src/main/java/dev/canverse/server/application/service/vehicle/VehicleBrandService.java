package dev.canverse.server.application.service.vehicle;

import dev.canverse.server.application.dto.vehicle.VehicleBrandCreate;
import dev.canverse.server.application.dto.vehicle.VehicleModelCreate;
import dev.canverse.server.domain.model.lookup.VehicleBrand;
import dev.canverse.server.domain.model.lookup.VehicleModel;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleBrandJpaRepository;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleModelJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleBrandService {
    private final VehicleBrandJpaRepository vehicleBrandJpaRepository;
    private final VehicleModelJpaRepository vehicleModelJpaRepository;

    public VehicleBrandCreate.Response createVehicleBrand(VehicleBrandCreate.Body body) {
        var brand = new VehicleBrand(body.name());

        if (vehicleBrandJpaRepository.existsByName(brand.getName()))
            throw new IllegalArgumentException("Vehicle brand already exists");

        vehicleBrandJpaRepository.save(brand);

        return new VehicleBrandCreate.Response(brand.getId().toString(), brand.getName());
    }

    public VehicleModelCreate.Response createVehicleModel(Long vehicleBrandId, VehicleModelCreate.Body body) {
        var brand = vehicleBrandJpaRepository.findReferenceById(vehicleBrandId)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle brand not found"));

        var model = new VehicleModel(brand, body.name());

        if (vehicleModelJpaRepository.existsByName(vehicleBrandId, model.getName()))
            throw new IllegalArgumentException("Vehicle model already exists for the brand");

        vehicleModelJpaRepository.save(model);

        return new VehicleModelCreate.Response(model.getId().toString(), vehicleBrandId.toString(), model.getName());
    }
}
