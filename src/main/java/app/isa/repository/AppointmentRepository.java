package app.isa.repository;

import app.isa.domain.model.Appointement;
import app.isa.domain.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointement, Long> {

    Optional<Appointement> findOne(Long id);
    List<Appointement> getAll();
}
