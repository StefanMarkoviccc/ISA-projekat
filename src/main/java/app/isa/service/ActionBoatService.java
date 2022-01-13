package app.isa.service;

import app.isa.domain.dto.DTO.ActionBoatDTO;
import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.model.ActionBoat;
import app.isa.domain.model.ActionHouse;

import java.util.List;

public interface ActionBoatService {
    List<ActionBoat> getForBoat(Long id);
    ActionBoat add(ActionBoatDTO actionBoatDTO);
    ActionBoat edit(Long id, ActionBoatDTO actionBoatDTO);
    boolean delete(Long id);
    ActionBoat getAction(Long id);
}
