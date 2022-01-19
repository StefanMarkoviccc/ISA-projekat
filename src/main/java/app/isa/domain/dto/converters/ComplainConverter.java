package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.ComplainDTO;
import app.isa.domain.dto.DTO.HouseDTO;
import app.isa.domain.model.Complain;

import java.util.ArrayList;
import java.util.List;

public class ComplainConverter {

    public static Complain fromDTO(ComplainDTO complainDTO){
        Complain complain = new Complain();
        complain.setId(complainDTO.getId());
        complain.setText(complainDTO.getText());
        complain.setComplainType(complainDTO.getComplainType());
        complain.setHouseId(complainDTO.getHouseId());
        complain.setUserId(complainDTO.getUserId());
        return complain;
    }

    public static ComplainDTO toDTO(Complain complain){
        ComplainDTO complainDTO = new ComplainDTO();
        complainDTO.setId(complain.getId());
        complainDTO.setText(complain.getText());
        complainDTO.setComplainType(complain.getComplainType());
        complainDTO.setHouseId(complain.getHouseId());
        complainDTO.setUserId(complain.getUserId());
        return  complainDTO;
    }

    public static List<ComplainDTO> toDTOList(List<Complain> complains){
        ArrayList<ComplainDTO> complainDTOList = new ArrayList<ComplainDTO>();
        for(Complain complain : complains){
            complainDTOList.add(toDTO(complain));
        }
        return complainDTOList;
    }
}
