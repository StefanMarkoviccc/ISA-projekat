package app.isa.controller;

import app.isa.domain.dto.BoatDTO;
import app.isa.domain.dto.HouseDTO;
import app.isa.domain.dto.converters.BoatConverter;
import app.isa.domain.dto.converters.HouseConverter;
import app.isa.domain.model.Boat;
import app.isa.domain.model.House;
import app.isa.repository.BoatRepository;
import app.isa.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/boats")

public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping
    public ResponseEntity<List<BoatDTO>> getBoats(){
        return new ResponseEntity<List<BoatDTO>>(BoatConverter.toDTOList(boatService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BoatDTO> getHouse(@PathVariable Long id){

        Boat boat = boatService.getBoat(id);
        if (boat == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<BoatDTO>(BoatConverter.toDTO(boat),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoatDTO> add(@RequestBody BoatDTO boatDTO){
        Boat boat = boatService.add(boatDTO);

        if(boat == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(BoatConverter.toDTO(boat),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BoatDTO> edit(@PathVariable Long id, @RequestBody BoatDTO boatDTO){
        Boat boat = boatService.edit(id,boatDTO);

        if(boat == null){
            return  new ResponseEntity<BoatDTO>(BoatConverter.toDTO(boat), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<BoatDTO>(BoatConverter.toDTO(boat), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(boatService.deleted(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
