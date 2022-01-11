package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.model.ActionHouse;

import java.util.ArrayList;
import java.util.List;

public class ActionHouseConverter {

    public static ActionHouse fromDTO(ActionHouseDTO actionHouseDTO){

        ActionHouse actionHouse = new ActionHouse();
        actionHouse.setId(actionHouseDTO.getId());
        actionHouse.setDateFrom(actionHouseDTO.getDateFrom());
        actionHouse.setDateTo(actionHouseDTO.getDateTo());
        actionHouse.setPrice(actionHouse.getPrice());

        return actionHouse;
    }

    public static ActionHouseDTO toDTO(ActionHouse actionHouse){

        ActionHouseDTO actionHouseDTO = new ActionHouseDTO();
        actionHouseDTO.setId(actionHouse.getId());
        actionHouseDTO.setDateFrom(actionHouse.getDateFrom());
        actionHouseDTO.setDateTo(actionHouse.getDateTo());

        return  actionHouseDTO;
    }

    public static List<ActionHouseDTO> toDTOList(List<ActionHouse> actionHouseList){
        ArrayList<ActionHouseDTO> actionHouseDTOS = new ArrayList<ActionHouseDTO>();
        for(ActionHouse actionHouse: actionHouseList){
            actionHouseDTOS.add(toDTO(actionHouse));
        }
        return actionHouseDTOS;
    }
}
