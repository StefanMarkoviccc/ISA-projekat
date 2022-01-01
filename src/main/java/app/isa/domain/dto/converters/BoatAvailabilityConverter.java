package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.BoatAvailabilityPeriodDTO;
import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.model.BoatAvailabilityPeriod;
import app.isa.domain.model.HouseAvailabilityPeriod;

import java.util.ArrayList;
import java.util.List;

public class BoatAvailabilityConverter {
    public static BoatAvailabilityPeriod fromDTO(BoatAvailabilityPeriodDTO boatAvailabilityPeriodDTO) {

        BoatAvailabilityPeriod boatAvailabilityPeriod = new BoatAvailabilityPeriod();
        boatAvailabilityPeriod.setId(boatAvailabilityPeriodDTO.getId());
        boatAvailabilityPeriod.setDateFrom(boatAvailabilityPeriodDTO.getDateFrom());
        boatAvailabilityPeriod.setDateTo(boatAvailabilityPeriodDTO.getDateTo());

        return boatAvailabilityPeriod;
    }

    public static BoatAvailabilityPeriodDTO toDTO(BoatAvailabilityPeriod boatAvailabilityPeriod){
        BoatAvailabilityPeriodDTO boatAvailabilityPeriodDTO = new BoatAvailabilityPeriodDTO();

        boatAvailabilityPeriodDTO.setId(boatAvailabilityPeriod.getId());
        boatAvailabilityPeriodDTO.setDateFrom(boatAvailabilityPeriod.getDateFrom());
        boatAvailabilityPeriodDTO.setDateTo(boatAvailabilityPeriod.getDateTo());

        return boatAvailabilityPeriodDTO;
    }

    public static List<BoatAvailabilityPeriodDTO> toDTOList(List<BoatAvailabilityPeriod> boatAvailabilities){
        ArrayList<BoatAvailabilityPeriodDTO> boatAvailabilityDTOList = new ArrayList<BoatAvailabilityPeriodDTO>();
        for(BoatAvailabilityPeriod boatAvailabilityPeriod : boatAvailabilities){
            boatAvailabilityDTOList.add(toDTO(boatAvailabilityPeriod));
        }
        return  boatAvailabilityDTOList;
    }
}
