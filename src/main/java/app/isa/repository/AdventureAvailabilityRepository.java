package app.isa.repository;

import app.isa.domain.model.Adventure;
import app.isa.domain.model.AdventureAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdventureAvailabilityRepository extends JpaRepository<AdventureAvailability, Long> {

    List<AdventureAvailability> getAllByAdventure(Adventure adventure);

}
