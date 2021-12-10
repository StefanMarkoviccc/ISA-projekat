package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.HouseDTO;
import app.isa.domain.model.House;

import java.util.ArrayList;
import java.util.List;

public class HouseConverter {

    public static House fromDTO(HouseDTO houseDTO){

        House house = new House();
        house.setId(houseDTO.getId());
        house.setAddress(houseDTO.getAddress());
        house.setDescription(houseDTO.getDescription());
        house.setGeographicalLength(houseDTO.getGeographicalLength());
        house.setGeographicalWidth(houseDTO.getGeographicalWidth());
        house.setName(houseDTO.getName());
        house.setRulesOfConduct(houseDTO.getRulesOfConduct());
        house.setAvailabilityPeriod(houseDTO.getAvailabilityPeriod());
        house.setAverage(houseDTO.getAverage());

        return house;
    }

    public static HouseDTO toDTO(House house){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(house.getId());
        houseDTO.setAddress(house.getAddress());
        houseDTO.setDescription(house.getDescription());
        houseDTO.setGeographicalLength(house.getGeographicalLength());
        houseDTO.setGeographicalWidth(house.getGeographicalWidth());
        houseDTO.setName(house.getName());
        houseDTO.setRulesOfConduct(house.getRulesOfConduct());
        houseDTO.setAvailabilityPeriod(house.getAvailabilityPeriod());
        houseDTO.setAverage(house.getAverage());

        return houseDTO;
    }

    public static List<HouseDTO> toDTOList(List<House> houses){
        ArrayList<HouseDTO> houseDTOList = new ArrayList<HouseDTO>();
        for(House house : houses){
            houseDTOList.add(toDTO(house));
        }
        return houseDTOList;
    }

}
