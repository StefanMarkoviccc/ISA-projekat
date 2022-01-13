package app.isa.controller;

import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.dto.DTO.BoatAvailabilityPeriodDTO;
import app.isa.domain.dto.DTO.HouseDTO;
import app.isa.domain.dto.converters.ActionHouseConverter;
import app.isa.domain.dto.converters.BoatAvailabilityConverter;
import app.isa.domain.dto.converters.HouseConverter;
import app.isa.domain.model.ActionHouse;
import app.isa.domain.model.House;
import app.isa.service.ActionHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/actionHouses")

public class ActionHouseController {

    @Autowired
    private ActionHouseService actionHouseService;

    @GetMapping
    public ResponseEntity<List<ActionHouseDTO>> getActionsByHouse(@PathVariable Long id){
        return new ResponseEntity<List<ActionHouseDTO>>(ActionHouseConverter.toDTOList(actionHouseService.getForHouse(id)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ActionHouseDTO> getActionHouse(@PathVariable Long id){

        ActionHouse actionHouse = actionHouseService.getAction(id);
        if (actionHouse == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ActionHouseDTO>(ActionHouseConverter.toDTO(actionHouse),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ActionHouseDTO> add(@RequestBody ActionHouseDTO actionHouseDTO){
        ActionHouse actionHouse = actionHouseService.add(actionHouseDTO);

        if(actionHouse == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ActionHouseConverter.toDTO(actionHouse),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ActionHouseDTO> edit(@PathVariable Long id, @RequestBody ActionHouseDTO actionHouseDTO){
        ActionHouse actionHouse= actionHouseService.edit(id,actionHouseDTO);

        if(actionHouse == null){
            return  new ResponseEntity<ActionHouseDTO>(ActionHouseConverter.toDTO(actionHouse), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<ActionHouseDTO>(ActionHouseConverter.toDTO(actionHouse), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(actionHouseService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
