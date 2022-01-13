package app.isa.service;


import app.isa.domain.dto.DTO.AdventureDTO;
import app.isa.domain.dto.converters.AdventureConverter;
import app.isa.domain.model.Adventure;
import app.isa.repository.AdventureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class AdventureServiceImplementation implements AdventureService {

    @Autowired
    private AdventureRepository adventureRepository;


    public Adventure add(AdventureDTO adventureDTO) {
        Adventure adventure = AdventureConverter.fromDTO(adventureDTO);

        return adventureRepository.save(adventure);
    }

    public boolean deleted(Long id) {
        Optional<Adventure> adventure = adventureRepository.findById(id);

        if (adventure.isEmpty()) {
            return false;
        }

        adventure.get().setDeleted(true);
        adventureRepository.save(adventure.get());
        return true;
    }

    @Override
    public List<Adventure> getList() {
        return adventureRepository.findAll();
    }

    @Override
    public Adventure getAdventure(Long id) {

        Optional<Adventure> adventure = adventureRepository.findById(id);

        if (adventure.isEmpty()) {
            return null;
        }

        return adventure.get();
    }

    @Override
    public Adventure edit(Long id, AdventureDTO adventureDTO) {
        Optional<Adventure> adventure = adventureRepository.findById(id);

        if (adventure.isEmpty()) {
            return null;
        }
        Adventure adventure1 = AdventureConverter.fromDTO(adventureDTO);

        adventure.get().setName(adventure1.getName());
        adventure.get().setAddress(adventure1.getAddress());
        adventure.get().setDescription(adventure1.getDescription());
        adventure.get().setBiography(adventure1.getBiography());
        adventure.get().setMaxNumberOfPeople(adventure1.getMaxNumberOfPeople());
        adventure.get().setAdventurePictures(adventure1.getAdventurePictures());
        adventure.get().setAdventureAppointment(adventure1.getAdventureAppointment());
        adventure.get().setRules(adventure1.getRules());
        adventure.get().setFishingEquipment(adventure1.getFishingEquipment());
        adventure.get().setPrice(adventure1.getPrice());
        adventure.get().setIsFreeCancelation(adventure1.getIsFreeCancelation());
        adventure.get().setCancelationPercent(adventure1.getCancelationPercent());

        return adventureRepository.save(adventure.get());
    }
}