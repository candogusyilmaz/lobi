package dev.canverse.server.infrastructure.persistence.jpa.vehicle;

import dev.canverse.server.domain.model.resource.Vehicle;
import dev.canverse.server.infrastructure.persistence.jpa.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleJpaRepository extends BaseJpaRepository<Vehicle, Long> {
}