package app.isa.service;

import app.isa.domain.dto.DTO.HouseDTO;
import app.isa.domain.model.House;

import java.util.List;

public interface HouseService {

    List<House> getList(String search);
    House getHouse(Long id);
    House edit(Long id, HouseDTO houseDTO);
    House add(HouseDTO houseDTO);
    boolean deleted(Long id);
}
