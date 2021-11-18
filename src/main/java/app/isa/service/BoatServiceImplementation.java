package app.isa.service;

import app.isa.domain.dto.DTO.BoatDTO;
import app.isa.domain.dto.converters.BoatConverter;
import app.isa.domain.model.Boat;
import app.isa.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatServiceImplementation implements BoatService{

    @Autowired
    private BoatRepository boatRepository;

    @Override
    public List<Boat> getList() {
        return boatRepository.findAll();
    }

    @Override
    public Boat getBoat(Long id) {
        Optional<Boat> boat = boatRepository.findById(id);

        if(boat.isEmpty()){
            return  null;
        }
        return  boat.get();
    }

    @Override
    public Boat edit(Long id, BoatDTO boatDTO) {
        Optional<Boat> boat = boatRepository.findById(id);

        if(boat.isEmpty()){
            return  null;
        }

        Boat boatData = BoatConverter.fromDTO(boatDTO);

        boat.get().setType(boatData.getType());
        boat.get().setName(boatData.getName());
        boat.get().setAddress(boatData.getAddress());
        boat.get().setRulesOfConduct(boatData.getRulesOfConduct());
        boat.get().setDeleted(boatData.isDeleted());
        boat.get().setMaxSpeed(boatData.getMaxSpeed());
        boat.get().setLength(boatData.getLength());
        boat.get().setPromotionalDescription(boatData.getPromotionalDescription());
        boat.get().setFishingEquipment(boatData.getFishingEquipment());
        boat.get().setEnginePower(boatData.getEnginePower());
        boat.get().setEngineNumber(boatData.getEngineNumber());
        boat.get().setCapacity(boatData.getCapacity());

        return  boatRepository.save(boat.get());
    }

    @Override
    public Boat add(BoatDTO boatDTO) {
        Boat boat = BoatConverter.fromDTO(boatDTO);
        return boatRepository.save(boat);
    }

    @Override
    public boolean deleted(Long id) {

        Optional<Boat> boat = boatRepository.findById(id);

        if(boat.isEmpty()){
            return  false;
        }

        boat.get().setDeleted(true);
        boatRepository.save(boat.get());

        return true;
    }
}
