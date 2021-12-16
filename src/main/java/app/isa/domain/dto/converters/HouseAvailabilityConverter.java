package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.AdventureAvailabilityDTO;
import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.model.AdventureAvailability;
import app.isa.domain.model.HouseAvailabilityPeriod;

import java.util.ArrayList;
import java.util.List;

public class HouseAvailabilityConverter {
    public static HouseAvailabilityPeriod fromDTO(HouseAvailabilityPeriodDTO houseAvailabilityPeriodDTO) {

        HouseAvailabilityPeriod houseAvailabilityPeriod = new HouseAvailabilityPeriod();
        houseAvailabilityPeriod.setId(houseAvailabilityPeriodDTO.getId());
        houseAvailabilityPeriod.setDateFrom(houseAvailabilityPeriodDTO.getDateFrom());
        houseAvailabilityPeriod.setDateTo(houseAvailabilityPeriodDTO.getDateTo());

        return houseAvailabilityPeriod;
    }

    public static HouseAvailabilityPeriodDTO toDTO(HouseAvailabilityPeriod houseAvailabilityPeriod){
        HouseAvailabilityPeriodDTO houseAvailabilityPeriodDTO = new HouseAvailabilityPeriodDTO();

        houseAvailabilityPeriodDTO.setId(houseAvailabilityPeriod.getId());
        houseAvailabilityPeriodDTO.setDateFrom(houseAvailabilityPeriod.getDateFrom());
        houseAvailabilityPeriodDTO.setDateTo(houseAvailabilityPeriod.getDateTo());

        return houseAvailabilityPeriodDTO;
    }

    public static List<HouseAvailabilityPeriodDTO> toDTOList(List<HouseAvailabilityPeriod> houseAvailabilities){
        ArrayList<HouseAvailabilityPeriodDTO> houseAvailabilityDTOList = new ArrayList<HouseAvailabilityPeriodDTO>();
        for(HouseAvailabilityPeriod houseAvailabilityPeriod : houseAvailabilities){
            houseAvailabilityDTOList.add(toDTO(houseAvailabilityPeriod));
        }
        return  houseAvailabilityDTOList;
    }
}
