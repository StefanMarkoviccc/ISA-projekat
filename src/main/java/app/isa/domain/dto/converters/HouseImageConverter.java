package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.HouseImageDTO;
import app.isa.domain.dto.DTO.RoomDTO;
import app.isa.domain.model.HouseImage;
import app.isa.domain.model.Room;

import java.util.ArrayList;
import java.util.List;

public class HouseImageConverter {
    public  static HouseImage fromDTO(HouseImageDTO houseImageDTO){

        HouseImage houseImage = new HouseImage();
        houseImage.setId(houseImageDTO.getId());
        houseImage.setContent(houseImageDTO.getContent());
        houseImage.setHouse(null);

        return houseImage;
    }

    public static  HouseImageDTO toDTO(HouseImage houseImage){
        HouseImageDTO houseImageDTO = new HouseImageDTO();
        houseImageDTO.setId(houseImage.getId());
        houseImageDTO.setContent(houseImage.getContent());
        houseImageDTO.setHouseId(houseImage.getHouse().getId());

        return houseImageDTO;
    }

    public  static List<HouseImageDTO> toDTOList(List<HouseImage> houseImages){
        ArrayList<HouseImageDTO> houseImageDTOS = new ArrayList<>();
        for(HouseImage houseImage: houseImages ){

            houseImageDTOS.add(toDTO(houseImage));
        }
        return  houseImageDTOS;
    }
}
