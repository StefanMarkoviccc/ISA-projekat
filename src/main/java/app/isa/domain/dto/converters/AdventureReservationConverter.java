package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.AdventureReservationDTO;
import app.isa.domain.model.AdventureReservation;

import java.util.ArrayList;
import java.util.List;

public class AdventureReservationConverter {

    public static AdventureReservation fromDTO(AdventureReservationDTO adventureReservationDTO) {

        AdventureReservation adventureReservation = new AdventureReservation();
        adventureReservation.setId(adventureReservationDTO.getId());
        adventureReservation.setAdditionalServices(adventureReservationDTO.getAdditionalServices());
        adventureReservation.setPlace(adventureReservationDTO.getPlace());
        adventureReservation.setDuration(adventureReservationDTO.getDuration());
        adventureReservation.setMaximumNumberOfPersons(adventureReservationDTO.getMaximumNumberOfPersons());
        adventureReservation.setPrice(adventureReservationDTO.getPrice());
        adventureReservation.setDateAndTime(adventureReservationDTO.getDateAndTime());

        return adventureReservation;
    }

    public static AdventureReservationDTO toDTO(AdventureReservation adventureReservation){
        AdventureReservationDTO adventureReservationDTO = new AdventureReservationDTO();

        adventureReservationDTO.setId(adventureReservation.getId());
        adventureReservationDTO.setDateAndTime(adventureReservation.getDateAndTime());
        adventureReservationDTO.setAdditionalServices(adventureReservation.getAdditionalServices());
        adventureReservationDTO.setDuration(adventureReservation.getDuration());
        adventureReservationDTO.setPlace(adventureReservation.getPlace());
        adventureReservationDTO.setPrice(adventureReservation.getPrice());
        adventureReservationDTO.setMaximumNumberOfPersons(adventureReservation.getMaximumNumberOfPersons());

        return adventureReservationDTO;
    }

    public static List<AdventureReservationDTO> toDTOList(List<AdventureReservation> adventureReservations){
        ArrayList<AdventureReservationDTO> adventureReservationDTOList = new ArrayList<AdventureReservationDTO>();
        for(AdventureReservation adventureReservation : adventureReservations){
            adventureReservationDTOList.add(toDTO(adventureReservation));
        }
        return  adventureReservationDTOList;
    }

}
