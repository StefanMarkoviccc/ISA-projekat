package app.isa.repository;

import app.isa.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdventureRepository extends JpaRepository<Appointment, Long> {

}
