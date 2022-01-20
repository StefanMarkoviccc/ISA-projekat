package app.isa.service;

import app.isa.domain.dto.DTO.BoatAvailabilityPeriodDTO;
import app.isa.domain.model.Boat;
import app.isa.domain.model.BoatAvailabilityPeriod;
import app.isa.domain.model.House;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.repository.BoatAvailabilityPeriodRepository;
import app.isa.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatAvailabilityPeriodServiceImplementation implements BoatAvailabilityPeriodService{

    @Autowired
    private BoatAvailabilityPeriodRepository boatAvailabilityPeriodRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private SearchBoatService searchBoatService;

    @Override
    public List<BoatAvailabilityPeriod> getForBoat(Long id) {
        Boat boat = boatRepository.getById(id);
        return  boatAvailabilityPeriodRepository.getAllByBoatAndDeleted(boat, false);
    }

    @Override
    public BoatAvailabilityPeriod add(BoatAvailabilityPeriodDTO boatAvailabilityPeriodDTO) {

        if(searchBoatService.isBoatTaken((boatAvailabilityPeriodDTO.getBoatId()), boatAvailabilityPeriodDTO.getDateFrom(), boatAvailabilityPeriodDTO.getDateTo())){
            return null;
        }

        Boat boat= boatRepository.getById(boatAvailabilityPeriodDTO.getBoatId());
        BoatAvailabilityPeriod boatAvailabilityPeriod = new BoatAvailabilityPeriod();
        boatAvailabilityPeriod.setDateTo(boatAvailabilityPeriodDTO.getDateTo());
        boatAvailabilityPeriod.setDateFrom(boatAvailabilityPeriodDTO.getDateFrom());
        boatAvailabilityPeriod.setDeleted(false);
        boatAvailabilityPeriod.setBoat(boat);

        return boatAvailabilityPeriodRepository.save(boatAvailabilityPeriod);
    }
}
