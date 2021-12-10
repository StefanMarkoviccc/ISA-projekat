package app.isa.service;

import app.isa.domain.dto.DTO.AdventureAvailabilityDTO;
import app.isa.domain.model.AdventureAvailability;

import java.util.List;

public interface AdventureAvailabilityService {

    List<AdventureAvailability> getForAdventure(Long id);
    AdventureAvailability add(AdventureAvailabilityDTO adventureAvailabilityDTO);
}
