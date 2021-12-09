package app.isa.repository;

import app.isa.domain.model.Boat;
import app.isa.domain.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {
    List<Boat> findAllByNameContaining(String name);

}
