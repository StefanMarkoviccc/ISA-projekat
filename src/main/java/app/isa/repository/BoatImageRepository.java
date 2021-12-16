package app.isa.repository;

import app.isa.domain.model.Boat;
import app.isa.domain.model.BoatImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoatImageRepository extends JpaRepository<BoatImage, Long> {

    List<BoatImage> findAllByBoat(Boat boat);
}
