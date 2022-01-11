package app.isa.repository;

import app.isa.domain.model.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComplainRepository extends JpaRepository<Complain, Long> {
    Optional<Complain> findById(Long id);
}
