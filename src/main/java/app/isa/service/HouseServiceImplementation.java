package app.isa.service;

import app.isa.domain.dto.HouseDTO;
import app.isa.domain.dto.converters.HouseConverter;
import app.isa.domain.model.House;
import app.isa.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImplementation implements  HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<House> getList() {
        return houseRepository.getAll();
    }

    @Override
    public House getHouse(Long id) {
        Optional<House> house = houseRepository.findOne(id);

        if(house.isEmpty()){
            return  null;
        }

        return  house.get();
    }

    public House add(HouseDTO houseDTO){
        House house = HouseConverter.fromDTO(houseDTO);
        return houseRepository.save(house);
    }

    @Override
    public House edit(Long id, HouseDTO houseDTO) {

        Optional<House> house = houseRepository.findOne(id);

        if(house.isEmpty()){
            return null;
        }

        House houseData = HouseConverter.fromDTO(houseDTO);

        house.get().setAddress(houseData.getAddress());
        house.get().setHouseOwner(houseData.getHouseOwner());
        house.get().setName(houseData.getName());
        house.get().setDescription(houseData.getDescription());
        house.get().setRulesOfConduct(houseData.getRulesOfConduct());
        house.get().setGeographicalLength(houseData.getGeographicalLength());
        house.get().setGeographicalWidth(houseData.getGeographicalWidth());

        return houseRepository.save(house.get());
    }

    @Override
    public boolean deleted(Long id) {

        Optional<House> house = houseRepository.findOne(id);

        if(house.isEmpty()){
            return  false;
        }

        house.get().setDeleted(true);
        houseRepository.save(house.get());

        return true;
    }
}
