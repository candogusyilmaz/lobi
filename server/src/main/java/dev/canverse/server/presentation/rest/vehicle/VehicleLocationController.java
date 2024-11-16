package dev.canverse.server.presentation.rest.vehicle;

import dev.canverse.server.application.dto.vehicle.VehicleLocationCreate;
import dev.canverse.server.application.service.vehicle.VehicleLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicles/locations")
public class VehicleLocationController {
    private final VehicleLocationService vehicleLocationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleLocationCreate.Response createVehicleBrand(@RequestBody VehicleLocationCreate.Body body) {
        return vehicleLocationService.createVehicleLocation(body);
    }
}
