package app.isa.repository;

import app.isa.domain.model.House;
import app.isa.domain.model.HouseImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface HouseImageRepository extends JpaRepository<HouseImage, Long> {

    List<HouseImage> findAllByHouse(House house);
}
