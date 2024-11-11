package dev.canverse.server;

import dev.canverse.server.domain.model.lookup.VehicleBrand;
import dev.canverse.server.domain.model.lookup.VehicleLocation;
import dev.canverse.server.domain.model.lookup.VehicleModel;
import dev.canverse.server.domain.model.reservation.VehicleReservation;
import dev.canverse.server.domain.model.resource.Vehicle;
import dev.canverse.server.infrastructure.persistence.jpa.VehicleJpaRepository;
import dev.canverse.server.infrastructure.persistence.jpa.VehicleReservationJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.TimeZone;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner init(VehicleReservationJpaRepository vrjp, VehicleJpaRepository vejh) {
        return args -> {
            var vehicleBrand = new VehicleBrand("Toyota");
            var vehicleModel = new VehicleModel(vehicleBrand, "Corolla");
            var vehicleLocation = new VehicleLocation("Lagos");
            var vehicle = new Vehicle(vehicleModel, vehicleLocation, 2021, "ABC123");
            vejh.saveAndFlush(vehicle);

            var vReservation = new VehicleReservation(vehicle, null, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
            vReservation.getMetadata().setStartKilometers(100);
            vrjp.saveAndFlush(vReservation);

            vrjp.findAll();
        };
    }
}
