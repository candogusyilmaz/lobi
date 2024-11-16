package dev.canverse.server.infrastructure.persistence.jpa.vehicle;

import dev.canverse.server.domain.model.lookup.VehicleLocation;
import dev.canverse.server.infrastructure.persistence.jpa.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLocationJpaRepository extends BaseJpaRepository<VehicleLocation, Long> {
    @Query("select count(vl) > 0 from VehicleLocation vl where lower(vl.name) = lower(:name)")
    boolean existsByName(String name);
}
