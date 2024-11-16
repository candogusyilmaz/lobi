package dev.canverse.server.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseJpaRepository<T, K> extends JpaRepository<T, K>, JpaSpecificationExecutor<T> {
    default Optional<T> findReferenceById(K id) {
        return existsById(id) ? Optional.of(getReferenceById(id)) : Optional.empty();
    }
}
