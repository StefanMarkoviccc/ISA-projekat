package app.isa.controller;

import app.isa.domain.dto.DTO.AdventureDTO;
import app.isa.domain.dto.DTO.BoatDTO;
import app.isa.domain.dto.converters.AdventureConverter;
import app.isa.domain.dto.converters.BoatConverter;
import app.isa.domain.model.Adventure;
import app.isa.domain.model.Boat;
import app.isa.service.AdventureService;
import app.isa.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AdventureController {

    @Autowired
    private AdventureService adventureService;

    @GetMapping
    public ResponseEntity<List<AdventureDTO>> getAdventure(){
        return new ResponseEntity<List<AdventureDTO>>(AdventureConverter.toDTOList(adventureService.getList()), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<AdventureDTO> add(@RequestBody AdventureDTO adventureDTO){
        Adventure adventure = adventureService.add(adventureDTO);

        if(adventure == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(AdventureConverter.toDTO(adventure),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AdventureDTO> edit(@PathVariable Long id, @RequestBody AdventureDTO adventureDTO){
        Adventure adventure = adventureService.edit(id,adventureDTO);

        if(adventure == null){
            return  new ResponseEntity<AdventureDTO>(AdventureConverter.toDTO(adventure), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<AdventureDTO>(AdventureConverter.toDTO(adventure), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(adventureService.deleted(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
