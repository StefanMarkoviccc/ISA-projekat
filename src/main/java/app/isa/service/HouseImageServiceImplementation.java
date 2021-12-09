package app.isa.service;

import app.isa.domain.dto.DTO.HouseImageDTO;
import app.isa.domain.dto.converters.HouseImageConverter;
import app.isa.domain.model.House;
import app.isa.domain.model.HouseImage;
import app.isa.repository.HouseImageRepository;
import app.isa.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseImageServiceImplementation implements HouseImageService{

    @Autowired
    private HouseImageRepository houseImageRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<HouseImage> getList(Long id) {
        Optional<House> house = houseRepository.findById(id);
       return houseImageRepository.findAllByHouse(house.get());
    }

    @Override
    public HouseImage getHouseImage(Long id) {
        Optional<HouseImage> houseImage = houseImageRepository.findById(id);

        if(houseImage.isEmpty()){
            return null;
        }
        return houseImage.get();
    }

    @Override
    public HouseImage add(HouseImageDTO houseImageDTO) {
        HouseImage houseImage= HouseImageConverter.fromDTO(houseImageDTO);
        houseImage.setHouse(houseRepository.getById(houseImageDTO.getHouseId()));
        return houseImageRepository.save(houseImage);
    }
}
