package app.isa.service;

import app.isa.domain.dto.DTO.HouseImageDTO;
import app.isa.domain.model.House;
import app.isa.domain.model.HouseImage;

import java.util.List;

public interface HouseImageService {

    List<HouseImage> getList(Long id);
    HouseImage getHouseImage(Long id);
    HouseImage add(HouseImageDTO houseImageDTODTO);

}
