package app.isa.repository;

import app.isa.domain.model.Appointment;
import app.isa.domain.model.House;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> getByClientAndDeleted(User user, boolean deleted);
    List<Appointment> getByHouse(House house);
    List<Appointment> getAllByHouseAndDeleted(House house, Boolean deleted);

}
