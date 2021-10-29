package app.isa.service;

import app.isa.domain.dto.HouseDTO;
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

    @Override
    public House edit(Long id, HouseDTO houseDTO) {
        return null;
    }

    @Override
    public boolean deleted(Long id) {
        return false;
    }
}
