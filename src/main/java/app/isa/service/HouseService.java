package app.isa.service;

import app.isa.domain.dto.HouseDTO;
import app.isa.domain.model.House;

import java.util.List;

public interface HouseService {

    List<House> getList();
    House getHouse(Long id);
    House edit(Long id, HouseDTO houseDTO);
    boolean deleted(Long id);
}
