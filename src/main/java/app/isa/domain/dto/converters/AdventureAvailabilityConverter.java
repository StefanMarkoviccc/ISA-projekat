package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.AdventureAvailabilityDTO;
import app.isa.domain.dto.DTO.AdventureDTO;
import app.isa.domain.model.Adventure;
import app.isa.domain.model.AdventureAvailability;

import java.util.ArrayList;
import java.util.List;

public class AdventureAvailabilityConverter {


    public static AdventureAvailability fromDTO(AdventureAvailabilityDTO adventureAvailabilityDTO) {

        AdventureAvailability adventureAvailability = new AdventureAvailability();
        adventureAvailability.setId(adventureAvailabilityDTO.getId());
        adventureAvailability.setFromDate(adventureAvailabilityDTO.getFormDate());
        adventureAvailability.setToDate(adventureAvailabilityDTO.getToDate());

        return adventureAvailability;
    }

    public static AdventureAvailabilityDTO toDTO(AdventureAvailability adventureAvailability){
        AdventureAvailabilityDTO adventureAvailabilityDTO = new AdventureAvailabilityDTO();

        adventureAvailabilityDTO.setId(adventureAvailability.getId());
        adventureAvailabilityDTO.setFormDate(adventureAvailability.getFromDate());
        adventureAvailabilityDTO.setToDate(adventureAvailability.getToDate());

        return adventureAvailabilityDTO;
    }

    public static List<AdventureAvailabilityDTO> toDTOList(List<AdventureAvailability> adventureAvailabilities){
        ArrayList<AdventureAvailabilityDTO> adventureAvailabilityDTOList = new ArrayList<AdventureAvailabilityDTO>();
        for(AdventureAvailability adventureAvailability : adventureAvailabilities){
            adventureAvailabilityDTOList.add(toDTO(adventureAvailability));
        }
        return  adventureAvailabilityDTOList;
    }
}



