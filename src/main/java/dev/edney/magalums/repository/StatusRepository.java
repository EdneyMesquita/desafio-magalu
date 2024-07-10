package dev.edney.magalums.repository;

import dev.edney.magalums.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
