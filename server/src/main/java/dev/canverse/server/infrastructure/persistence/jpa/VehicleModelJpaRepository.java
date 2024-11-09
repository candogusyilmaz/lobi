package dev.canverse.server.infrastructure.persistence.jpa;

import dev.canverse.server.domain.vehicle.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleModelJpaRepository extends JpaRepository<VehicleModel, Long>, JpaSpecificationExecutor<VehicleModel> {
}