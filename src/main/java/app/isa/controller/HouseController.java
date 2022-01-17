package app.isa.controller;

import app.isa.domain.dto.DTO.HouseDTO;
import app.isa.domain.dto.DTO.SearchHousesDTO;
import app.isa.domain.dto.converters.HouseConverter;
import app.isa.domain.model.House;
import app.isa.service.HouseService;
import app.isa.service.SearchHousesService;
import org.hibernate.query.QueryParameter;
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

    @Autowired
    private SearchHousesService searchHousesService;

    @GetMapping
    public ResponseEntity<List<HouseDTO>> getHouses(@RequestParam String search){
        return new ResponseEntity<List<HouseDTO>>(HouseConverter.toDTOList(houseService.getList(search)), HttpStatus.OK);
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

    @PostMapping(path = "/search")
    public ResponseEntity<?> searchByDate(@RequestBody SearchHousesDTO searchHousesDTO){
        return new ResponseEntity<>(searchHousesService.getBySearchDate(searchHousesDTO.getStartDate(), searchHousesDTO.getEndDate()), HttpStatus.OK);
    }


    @PostMapping(path = "/house/{id}")
    public ResponseEntity<?> isHouseTaken(@RequestBody Long id, @RequestBody SearchHousesDTO searchHousesDTO){
        return  new ResponseEntity<>(searchHousesService.isHouseTaken(id,searchHousesDTO.getStartDate(), searchHousesDTO.getEndDate()), HttpStatus.OK);
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