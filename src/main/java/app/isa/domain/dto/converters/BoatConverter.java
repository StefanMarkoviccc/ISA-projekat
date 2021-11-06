package app.isa.domain.dto.converters;

import app.isa.domain.dto.BoatDTO;
import app.isa.domain.model.Boat;

import java.util.ArrayList;
import java.util.List;

public class BoatConverter {

    public  static Boat fromDTO(BoatDTO boatDTO){

        Boat boat = new Boat();
        boat.setId(boatDTO.getId());
        boat.setAddress(boatDTO.getAddress());
        boat.setCapacity(boatDTO.getCapacity());
        boat.setEngineNumber(boatDTO.getEngineNumber());
        boat.setEnginePower(boatDTO.getEnginePower());
        boat.setName(boatDTO.getName());
        boat.setLength(boatDTO.getLength());
        boat.setRulesOfConduct(boatDTO.getRulesOfConduct());
        boat.setFishingEquipment(boatDTO.getFishingEquipment());
        boat.setMaxSpeed(boatDTO.getMaxSpeed());
        boat.setPromotionalDescription(boatDTO.getPromotionalDescription());
        boat.setType(boatDTO.getType());

        return boat;
    }

    public static  BoatDTO toDTO(Boat boat){
        BoatDTO boatDTO = new BoatDTO();
        boatDTO.setId(boat.getId());
        boatDTO.setAddress(boat.getAddress());
        boatDTO.setCapacity(boat.getCapacity());
        boatDTO.setEngineNumber(boat.getEngineNumber());
        boatDTO.setEnginePower(boat.getEnginePower());
        boatDTO.setName(boat.getName());
        boatDTO.setLength(boat.getLength());
        boatDTO.setRulesOfConduct(boat.getRulesOfConduct());
        boatDTO.setFishingEquipment(boat.getFishingEquipment());
        boatDTO.setMaxSpeed(boat.getMaxSpeed());
        boatDTO.setPromotionalDescription(boat.getPromotionalDescription());
        boatDTO.setType(boat.getType());

        return boatDTO;
    }

    public  static List<BoatDTO> toDTOList(List<Boat> boats){
        ArrayList<BoatDTO> boatDTOList = new ArrayList<>();
        for(Boat boat : boats){
            boatDTOList.add(toDTO(boat));
        }
        return  boatDTOList;
    }
}
