package dev.canverse.server;

import dev.canverse.server.domain.model.lookup.VehicleBrand;
import dev.canverse.server.domain.model.lookup.VehicleLocation;
import dev.canverse.server.domain.model.lookup.VehicleModel;
import dev.canverse.server.domain.model.reservation.VehicleReservation;
import dev.canverse.server.domain.model.resource.Vehicle;
import dev.canverse.server.infrastructure.persistence.jpa.VehicleReservationJpaRepository;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleBrandJpaRepository;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleJpaRepository;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleLocationJpaRepository;
import dev.canverse.server.infrastructure.persistence.jpa.vehicle.VehicleModelJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.TimeZone;

@SpringBootApplication
public class Server {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(Server.class, args);
    }

    @Bean
    CommandLineRunner init(
            VehicleBrandJpaRepository vbjp,
            VehicleModelJpaRepository vmjp,
            VehicleLocationJpaRepository vljp,
            VehicleReservationJpaRepository vrjp,
            VehicleJpaRepository vejh) {
        return args -> {
            var vehicleBrand = vbjp.saveAndFlush(new VehicleBrand("Toyota"));
            var vehicleModel = vmjp.saveAndFlush(new VehicleModel(vehicleBrand, "Corolla"));
            var vehicleLocation = vljp.saveAndFlush(new VehicleLocation("Turkey"));
            var vehicle = vejh.saveAndFlush(new Vehicle(vehicleModel, vehicleLocation, 2021, "06ABC123"));
            var vehicle2 = vejh.saveAndFlush(new Vehicle(vehicleModel, vehicleLocation, 2021, "55CDY124"));
            var reservation = vrjp.saveAndFlush(new VehicleReservation(
                    vehicle,
                    null,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusDays(2)));
        };
    }
}
