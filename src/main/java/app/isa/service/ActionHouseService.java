package app.isa.service;

import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.model.ActionHouse;

import java.util.List;

public interface ActionHouseService {
    List<ActionHouse> getForHouse(Long id);
    ActionHouse add(ActionHouseDTO actionHouseDTO);
    ActionHouse edit(Long id, ActionHouseDTO actionHouseDTO);
    boolean delete(Long id);
    ActionHouse getAction(Long id);
}
