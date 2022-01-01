package app.isa.controller;

import app.isa.domain.dto.DTO.BoatAvailabilityPeriodDTO;
import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.dto.converters.BoatAvailabilityConverter;
import app.isa.domain.dto.converters.HouseAvailabilityConverter;
import app.isa.domain.model.BoatAvailabilityPeriod;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.service.BoatAvailabilityPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/boatAvailabilityPeriods")

public class BoatAvailabilityPeriodController {

    @Autowired
    private BoatAvailabilityPeriodService boatAvailabilityPeriodService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<BoatAvailabilityPeriodDTO>> getForBoat(@PathVariable Long id){
        return new ResponseEntity<List<BoatAvailabilityPeriodDTO>>(BoatAvailabilityConverter.toDTOList(boatAvailabilityPeriodService.getForBoat(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoatAvailabilityPeriodDTO> add(@RequestBody BoatAvailabilityPeriodDTO boatAvailabilityPeriodDTO){
        BoatAvailabilityPeriod boatAvailabilityPeriod = boatAvailabilityPeriodService.add(boatAvailabilityPeriodDTO);

        if(boatAvailabilityPeriod == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(BoatAvailabilityConverter.toDTO(boatAvailabilityPeriod), HttpStatus.OK);
    }
}
