package dev.canverse.server.infrastructure.persistence.jpa;

import dev.canverse.server.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationJpaRepository extends JpaRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {
}