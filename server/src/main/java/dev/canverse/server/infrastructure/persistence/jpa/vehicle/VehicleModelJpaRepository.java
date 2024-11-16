package dev.canverse.server.infrastructure.persistence.jpa.vehicle;

import dev.canverse.server.domain.model.lookup.VehicleModel;
import dev.canverse.server.infrastructure.persistence.jpa.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleModelJpaRepository extends BaseJpaRepository<VehicleModel, Long> {
    @Query("select count(m) > 0 from VehicleModel m where m.brand.id = :vehicleBrandId and lower(m.name) = lower(:name)")
    boolean existsByName(Long vehicleBrandId, String name);
}
