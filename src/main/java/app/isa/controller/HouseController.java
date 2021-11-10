package app.isa.controller;

import app.isa.domain.dto.HouseDTO;
import app.isa.domain.dto.RegistrationDTO;
import app.isa.domain.dto.converters.HouseConverter;
import app.isa.domain.model.House;
import app.isa.service.HouseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/houses")

public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping
    public ResponseEntity<List<HouseDTO>> getHouses(){
        return new ResponseEntity<List<HouseDTO>>(HouseConverter.toDTOList(houseService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable Long id){

        House house = houseService.getHouse(id);
        if (house == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<HouseDTO>(HouseConverter.toDTO(house),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<HouseDTO> add(@RequestBody HouseDTO houseDTO){
        House house = houseService.add(houseDTO);

        if(house == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HouseConverter.toDTO(house),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HouseDTO> edit(@PathVariable Long id, @RequestBody HouseDTO houseDTO){
        House house = houseService.edit(id,houseDTO);

        if(house == null){
            return  new ResponseEntity<HouseDTO>(HouseConverter.toDTO(house), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<HouseDTO>(HouseConverter.toDTO(house), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(houseService.deleted(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}