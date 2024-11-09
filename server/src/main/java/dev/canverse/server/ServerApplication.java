package dev.canverse.server;

import dev.canverse.server.domain.vehicle.*;
import dev.canverse.server.infrastructure.persistence.jpa.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner init(VehicleLocationJpaRepository vlr, VehicleReservationJpaRepository repo, VehicleBrandJpaRepository vbr, VehicleModelJpaRepository vmr, VehicleJpaRepository veh) {
        return args -> {
            var vehicleBrand = new VehicleBrand("Toyota");
            vbr.save(vehicleBrand);

            var vehicleModel = new VehicleModel(vehicleBrand, "Corolla");
            vmr.save(vehicleModel);

            var vehicleLocation = new VehicleLocation("Lagos");
            vlr.save(vehicleLocation);

            var vehicle = new Vehicle(vehicleModel, vehicleLocation, 2021, "ABC123");
            veh.save(vehicle);

            var vReservation = new VehicleReservation(vehicle, null, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
            vReservation.setStartKilometers(100);
            repo.save(vReservation);

            var all = repo.findAll();

            System.out.println(all);
        };
    }
}
