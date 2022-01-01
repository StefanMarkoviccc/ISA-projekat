package app.isa.repository;

import app.isa.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoatAvailabilityPeriodRepository extends JpaRepository<BoatAvailabilityPeriod, Long> {
    List<BoatAvailabilityPeriod> getAllByBoat(Boat boat);
}
