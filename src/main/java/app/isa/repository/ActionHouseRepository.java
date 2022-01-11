package app.isa.repository;

import app.isa.domain.model.ActionHouse;
import app.isa.domain.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionHouseRepository extends JpaRepository<ActionHouse, Long> {
    List<ActionHouse> getAllByHouse(House house);
}
