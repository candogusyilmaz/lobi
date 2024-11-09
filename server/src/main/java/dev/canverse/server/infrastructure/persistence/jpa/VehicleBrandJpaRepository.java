package dev.canverse.server.infrastructure.persistence.jpa;

import dev.canverse.server.domain.vehicle.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBrandJpaRepository extends JpaRepository<VehicleBrand, Long>, JpaSpecificationExecutor<VehicleBrand> {
}