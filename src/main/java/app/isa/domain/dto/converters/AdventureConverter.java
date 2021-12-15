package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.AdventureDTO;
import app.isa.domain.model.Adventure;

import java.util.ArrayList;
import java.util.List;

public class AdventureConverter {

    public static Adventure fromDTO(AdventureDTO adventureDTO) {

        Adventure adventure = new Adventure();
        adventure.setId(adventureDTO.getId());
        adventure.setName(adventureDTO.getName());
        adventure.setAddress(adventureDTO.getAddress());
        adventure.setDescription(adventureDTO.getDescription());
        adventure.setBiography(adventureDTO.getBiography());
        adventure.setMaxNumberOfPeople(adventureDTO.getMaxNumberOfPeople());
        adventure.setAdventureAppointment(adventureDTO.getAdventureAppointment());
        adventure.setRules(adventureDTO.getRules());
        adventure.setFishingEquipment(adventureDTO.getFishingEquipment());
        adventure.setPrice(adventureDTO.getPrice());

        return adventure;
    }

    public static AdventureDTO toDTO(Adventure adventure){
        AdventureDTO adventureDTO = new AdventureDTO();

        adventureDTO.setId(adventure.getId());
        adventureDTO.setName(adventure.getName());
        adventureDTO.setAddress(adventure.getAddress());
        adventureDTO.setDescription(adventure.getDescription());
        adventureDTO.setBiography(adventure.getBiography());
        adventureDTO.setMaxNumberOfPeople(adventure.getMaxNumberOfPeople());
        adventureDTO.setAdventureAppointment(adventure.getAdventureAppointment());
        adventureDTO.setRules(adventure.getRules());
        adventureDTO.setFishingEquipment(adventure.getFishingEquipment());
        adventureDTO.setPrice(adventure.getPrice());

        return adventureDTO;
    }

    public static List<AdventureDTO> toDTOList(List<Adventure> adventures){
        ArrayList<AdventureDTO> adventureDTOList = new ArrayList<AdventureDTO>();
        for(Adventure adventure : adventures){
            adventureDTOList.add(toDTO(adventure));
        }
        return  adventureDTOList;
    }
}

