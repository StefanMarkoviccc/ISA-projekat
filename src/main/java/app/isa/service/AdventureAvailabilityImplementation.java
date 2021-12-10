package app.isa.service;
import app.isa.domain.dto.DTO.AdventureAvailabilityDTO;
import app.isa.domain.model.*;
import app.isa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdventureAvailabilityImplementation implements AdventureAvailabilityService {

    @Autowired
    private AdventureAvailabilityRepository adventureAvailabilityRepository;

    @Autowired
    private AdventureRepository adventureRepository;

    @Override
    public List<AdventureAvailability> getForAdventure(Long id) {
        Adventure adventure = adventureRepository.getById(id);

        return adventureAvailabilityRepository.getAllByAdventure(adventure);
    }

    @Override
    public AdventureAvailability add(AdventureAvailabilityDTO adventureAvailabilityDTO) {

        Adventure adventure = adventureRepository.getById(adventureAvailabilityDTO.getAdventureId());
        AdventureAvailability adventureAvailability  =new AdventureAvailability();
        adventureAvailability.setToDate(adventureAvailabilityDTO.getToDate());
        adventureAvailability.setFromDate(adventureAvailabilityDTO.getFormDate());
        adventureAvailability.setDeleted(false);
        adventureAvailability.setAdventure(adventure);

        return adventureAvailabilityRepository.save(adventureAvailability);
    }
}
