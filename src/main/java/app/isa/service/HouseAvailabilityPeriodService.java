package app.isa.service;

import app.isa.domain.dto.DTO.AdventureAvailabilityDTO;
import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.dto.DTO.HouseImageDTO;
import app.isa.domain.model.AdventureAvailability;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.domain.model.HouseImage;

import java.util.List;

public interface HouseAvailabilityPeriodService {
    List<HouseAvailabilityPeriod> getForHouse(Long id);
    HouseAvailabilityPeriod add(HouseAvailabilityPeriodDTO houseAvailabilityPeriodDTO);
}
