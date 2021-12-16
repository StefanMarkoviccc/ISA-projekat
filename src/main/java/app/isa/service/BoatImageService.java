package app.isa.service;

import app.isa.domain.dto.DTO.BoatImageDTO;
import app.isa.domain.model.BoatImage;

import java.util.List;

public interface BoatImageService {

    List<BoatImage> getList(Long id);
    BoatImage getBoatImage(Long id);
    BoatImage add(BoatImageDTO boatImageDTO);
}
