package app.isa.service;

import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.model.House;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.repository.HouseAvailabilityPeriodRepository;
import app.isa.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseAvailabilityPeriodServiceImplementation implements HouseAvailabilityPeriodService{

    @Autowired
    private HouseAvailabilityPeriodRepository houseAvailabilityPeriodRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<HouseAvailabilityPeriod> getForHouse(Long id) {
        House house = houseRepository.getById(id);

        return houseAvailabilityPeriodRepository.getAllByHouse(house);
    }

    @Override
    public HouseAvailabilityPeriod add(HouseAvailabilityPeriodDTO houseAvailabilityPeriodDTO) {

        House house = houseRepository.getById(houseAvailabilityPeriodDTO.getHouseId());
        HouseAvailabilityPeriod houseAvailabilityPeriod = new HouseAvailabilityPeriod();
        houseAvailabilityPeriod.setDateTo(houseAvailabilityPeriodDTO.getDateTo());
        houseAvailabilityPeriod.setDateFrom(houseAvailabilityPeriodDTO.getDateFrom());
        houseAvailabilityPeriod.setDeleted(false);
        houseAvailabilityPeriod.setHouse(house);

        return houseAvailabilityPeriodRepository.save(houseAvailabilityPeriod);
    }
}
