package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.ActionBoatDTO;
import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.model.ActionBoat;
import app.isa.domain.model.ActionHouse;

import java.util.ArrayList;
import java.util.List;

public class ActionBoatConverter {
    public static ActionBoat fromDTO(ActionBoatDTO actionBoatDTO){

        ActionBoat actionBoat = new ActionBoat();
        actionBoat.setId(actionBoatDTO.getId());
        actionBoat.setDateFrom(actionBoatDTO.getDateFrom());
        actionBoat.setDateTo(actionBoatDTO.getDateTo());
        actionBoat.setPrice(actionBoatDTO.getPrice());
        actionBoat.setAdditionalServices(actionBoatDTO.getAdditionalServices());

        return actionBoat;
    }

    public static ActionBoatDTO toDTO(ActionBoat actionBoat){

        ActionBoatDTO actionBoatDTO = new ActionBoatDTO();
        actionBoatDTO.setId(actionBoat.getId());
        actionBoatDTO.setDateFrom(actionBoat.getDateFrom());
        actionBoatDTO.setDateTo(actionBoat.getDateTo());
        actionBoatDTO.setPrice(actionBoat.getPrice());
        actionBoatDTO.setAdditionalServices(actionBoat.getAdditionalServices());

        return  actionBoatDTO;
    }

    public static List<ActionBoatDTO> toDTOList(List<ActionBoat> actionBoats){
        ArrayList<ActionBoatDTO> actionBoatDTOS = new ArrayList<ActionBoatDTO>();
        for(ActionBoat actionBoat: actionBoats){
            actionBoatDTOS.add(toDTO(actionBoat));
        }
        return actionBoatDTOS;
    }
}
