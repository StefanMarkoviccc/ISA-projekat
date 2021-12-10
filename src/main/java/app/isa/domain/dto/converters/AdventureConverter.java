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
        adventure.setLagitude(adventureDTO.getLagitude());
        adventure.setLongitude(adventureDTO.getLongitude());
        adventure.setDescription(adventureDTO.getDescription());
        adventure.setBiography(adventureDTO.getBiography());
        adventure.setAdventurePictures(adventureDTO.getAdventurePictures());
        adventure.setMaxNumberOfPeople(adventureDTO.getMaxNumberOfPeople());
        adventure.setAdventureAppointment(adventureDTO.getAdventureAppointment());
        adventure.setRules(adventureDTO.getRules());
        adventure.setFishingEquipment(adventureDTO.getFishingEquipment());
        adventure.setCancelationPercent(adventureDTO.getCancelationPercent());
        adventure.setLocation(adventureDTO.getLocation());
        adventure.setStanding(adventureDTO.getStanding());
        adventure.setAdditionalServices(adventureDTO.getAdditionalServices());
        adventure.setPrice(adventureDTO.getPrice());

        return adventure;
    }

    public static AdventureDTO toDTO(Adventure adventure){
        AdventureDTO adventureDTO = new AdventureDTO();

        adventureDTO.setId(adventure.getId());
        adventureDTO.setName(adventure.getName());
        adventureDTO.setAddress(adventure.getAddress());
        adventureDTO.setLagitude(adventure.getLagitude());
        adventureDTO.setLongitude(adventure.getLongitude());
        adventureDTO.setDescription(adventure.getDescription());
        adventureDTO.setBiography(adventure.getBiography());
        adventureDTO.setAdventurePictures(adventure.getAdventurePictures());
        adventureDTO.setMaxNumberOfPeople(adventure.getMaxNumberOfPeople());
        adventureDTO.setAdventureAppointment(adventure.getAdventureAppointment());
        adventureDTO.setRules(adventure.getRules());
        adventureDTO.setFishingEquipment(adventure.getFishingEquipment());
        adventureDTO.setCancelationPercent(adventure.getCancelationPercent());
        adventureDTO.setLocation(adventure.getLocation());
        adventureDTO.setStanding(adventure.getStanding());
        adventureDTO.setAdditionalServices(adventure.getAdditionalServices());
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

