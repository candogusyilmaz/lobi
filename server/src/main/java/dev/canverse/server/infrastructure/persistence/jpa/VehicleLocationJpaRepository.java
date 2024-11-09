package dev.canverse.server.infrastructure.persistence.jpa;

import dev.canverse.server.domain.vehicle.VehicleLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLocationJpaRepository extends JpaRepository<VehicleLocation, Long>, JpaSpecificationExecutor<VehicleLocation> {
}