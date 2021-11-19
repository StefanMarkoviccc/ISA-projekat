package app.isa.repository;

import app.isa.domain.model.AdventureReservation;
import app.isa.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdventureReservationRepository extends JpaRepository<AdventureReservation, Long> {

}
