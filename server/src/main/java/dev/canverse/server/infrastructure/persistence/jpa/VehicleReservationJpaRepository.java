package dev.canverse.server.infrastructure.persistence.jpa;

import dev.canverse.server.domain.vehicle.VehicleReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReservationJpaRepository extends JpaRepository<VehicleReservation, Long>, JpaSpecificationExecutor<VehicleReservation> {
}