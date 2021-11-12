package app.isa.service;

import app.isa.domain.dto.DTO.BoatDTO;
import app.isa.domain.model.Boat;

import java.util.List;

public interface BoatService {

    List<Boat> getList();
    Boat getBoat(Long id);
    Boat edit(Long id, BoatDTO boatDTO);
    Boat add(BoatDTO boatDTO);
    boolean deleted(Long id);
}
