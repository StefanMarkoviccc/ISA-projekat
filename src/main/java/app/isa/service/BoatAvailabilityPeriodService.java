package app.isa.service;

import app.isa.domain.dto.DTO.BoatAvailabilityPeriodDTO;
import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.model.BoatAvailabilityPeriod;
import app.isa.domain.model.HouseAvailabilityPeriod;

import java.util.List;

public interface BoatAvailabilityPeriodService {
    List<BoatAvailabilityPeriod> getForBoat(Long id);
    BoatAvailabilityPeriod add(BoatAvailabilityPeriodDTO boatAvailabilityPeriodDTO);
}
