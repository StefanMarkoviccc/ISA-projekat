package app.isa.controller;

import app.isa.domain.dto.DTO.AdventureAvailabilityDTO;
import app.isa.domain.dto.converters.AdventureAvailabilityConverter;
import app.isa.domain.model.AdventureAvailability;
import app.isa.service.AdventureAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



public class AdventureAvailabilityController {

    @Autowired
    private AdventureAvailabilityService adventureAvailabilityService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<AdventureAvailabilityDTO>> getAdventureAvailability(@PathVariable Long id){
        return new ResponseEntity<List<AdventureAvailabilityDTO>>(AdventureAvailabilityConverter.toDTOList(adventureAvailabilityService.getForAdventure(id)), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<AdventureAvailabilityDTO> add(@RequestBody AdventureAvailabilityDTO adventureAvailabilityDTO){
        AdventureAvailability adventureAvailability = adventureAvailabilityService.add(adventureAvailabilityDTO);

        if(adventureAvailability == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(AdventureAvailabilityConverter.toDTO(adventureAvailability),HttpStatus.CREATED);
    }

}
