package app.isa.repository;

import app.isa.domain.model.DeleteAccRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeleteAccRequestRepository extends JpaRepository<DeleteAccRequest,Long> {
    Optional<DeleteAccRequest> findById(Long id);
}
