package app.isa.repository;

import app.isa.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseAvailabilityPeriodRepository extends JpaRepository<HouseAvailabilityPeriod, Long> {
    List<HouseAvailabilityPeriod> getAllByHouse(House house);
}
