package app.isa.repository;

import app.isa.domain.model.ActionBoat;
import app.isa.domain.model.ActionHouse;
import app.isa.domain.model.Boat;
import app.isa.domain.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionBoatRepository extends JpaRepository<ActionBoat, Long> {
    List<ActionBoat> getAllByBoat(Boat boat);

}
