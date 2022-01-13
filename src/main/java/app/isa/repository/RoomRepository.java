package app.isa.repository;

import app.isa.domain.model.House;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> getAllByHouse(House house);

}
