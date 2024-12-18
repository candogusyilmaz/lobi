package dev.canverse.server.infrastructure.persistence.jpa.vehicle;

import dev.canverse.server.domain.model.lookup.VehicleBrand;
import dev.canverse.server.infrastructure.persistence.jpa.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBrandJpaRepository extends BaseJpaRepository<VehicleBrand, Long> {
    @Query("select count(b) > 0 from VehicleBrand b where lower(b.name) = lower(:name)")
    boolean existsByName(String name);
}
