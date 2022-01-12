package app.isa.controller;

import app.isa.domain.dto.DTO.ActionBoatDTO;
import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.dto.converters.ActionBoatConverter;
import app.isa.domain.dto.converters.ActionHouseConverter;
import app.isa.domain.model.ActionBoat;
import app.isa.domain.model.ActionHouse;
import app.isa.service.ActionBoatService;
import app.isa.service.ActionHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/actionBoats")


public class ActionBoatController {
    @Autowired
    private ActionBoatService actionBoatService;

    @GetMapping
    public ResponseEntity<List<ActionBoatDTO>> getActionsByBoat(@PathVariable Long id){
        return new ResponseEntity<List<ActionBoatDTO>>(ActionBoatConverter.toDTOList(actionBoatService.getForBoat(id)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ActionBoatDTO> getActionBoat(@PathVariable Long id){

      ActionBoat actionBoat = actionBoatService.getAction(id);
        if (actionBoat == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ActionBoatDTO>(ActionBoatConverter.toDTO(actionBoat),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ActionBoatDTO> add(@RequestBody ActionBoatDTO actionBoatDTO){
        ActionBoat actionBoat = actionBoatService.add(actionBoatDTO);

        if(actionBoat == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ActionBoatConverter.toDTO(actionBoat),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ActionBoatDTO> edit(@PathVariable Long id, @RequestBody ActionBoatDTO actionBoatDTO){
        ActionBoat actionBoat= actionBoatService.edit(id,actionBoatDTO);

        if(actionBoat == null){
            return  new ResponseEntity<ActionBoatDTO>(ActionBoatConverter.toDTO(actionBoat), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<ActionBoatDTO>(ActionBoatConverter.toDTO(actionBoat), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(actionBoatService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
