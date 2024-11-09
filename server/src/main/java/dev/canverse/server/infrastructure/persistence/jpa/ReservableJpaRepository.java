package dev.canverse.server.infrastructure.persistence.jpa;

import dev.canverse.server.domain.reservation.Reservable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservableJpaRepository extends JpaRepository<Reservable, Long>, JpaSpecificationExecutor<Reservable> {
}