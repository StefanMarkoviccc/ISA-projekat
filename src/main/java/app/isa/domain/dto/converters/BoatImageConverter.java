package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.BoatImageDTO;
import app.isa.domain.model.BoatImage;

import java.util.ArrayList;
import java.util.List;

public class BoatImageConverter {

    public static BoatImage fromDTO(BoatImageDTO boatImageDTO){
        BoatImage boatImage = new BoatImage();
        boatImage.setId(boatImageDTO.getId());
        boatImage.setContent(boatImageDTO.getContent());
        boatImage.setBoat(null);

        return  boatImage;
    }

    public static BoatImageDTO toDTO(BoatImage boatImage){
        BoatImageDTO boatImageDTO = new BoatImageDTO();
        boatImageDTO.setId(boatImage.getId());
        boatImageDTO.setContent(boatImage.getContent());
        boatImageDTO.setBoatId(boatImage.getBoat().getId());

        return  boatImageDTO;
    }

    public  static List<BoatImageDTO> toDTOList(List<BoatImage> boatImages){
        ArrayList<BoatImageDTO> boatImagesDTOS = new ArrayList<>();
        for(BoatImage boatImage: boatImages ){

            boatImagesDTOS.add(toDTO(boatImage));
        }
        return  boatImagesDTOS;
    }
}
