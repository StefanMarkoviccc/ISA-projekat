package app.isa.repository;

import app.isa.domain.model.Appointment;
import app.isa.domain.model.AppointmentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentReposrtRepository extends JpaRepository<AppointmentReport, Long> {

}
