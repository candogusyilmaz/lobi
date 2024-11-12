package dev.canverse.server.presentation.rest.vehicle;

import dev.canverse.server.application.dto.vehicle.VehicleBrandCreate;
import dev.canverse.server.application.service.vehicle.VehicleBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicle/brands")
public class VehicleBrandController {
    private final VehicleBrandService vehicleBrandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleBrandCreate.Response createVehicleBrand(@RequestBody VehicleBrandCreate.Body body) {
        return vehicleBrandService.createVehicleBrand(body);
    }
}
