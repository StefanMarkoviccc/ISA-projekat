package app.isa.controller;

import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.dto.converters.HouseAvailabilityConverter;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.service.HouseAvailabilityPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/houseAvailabilityPeriods")

public class HouseAvailabilityPeriodController {

    @Autowired
    private HouseAvailabilityPeriodService houseAvailabilityPeriodService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<HouseAvailabilityPeriodDTO>> getForHouse(@PathVariable Long id){
        return new ResponseEntity<List<HouseAvailabilityPeriodDTO>>(HouseAvailabilityConverter.toDTOList(houseAvailabilityPeriodService.getForHouse(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HouseAvailabilityPeriodDTO> add(@RequestBody HouseAvailabilityPeriodDTO houseAvailabilityPeriodDTO){
        HouseAvailabilityPeriod houseAvailabilityPeriod = houseAvailabilityPeriodService.add(houseAvailabilityPeriodDTO);

            if(houseAvailabilityPeriod == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>(HouseAvailabilityConverter.toDTO(houseAvailabilityPeriod), HttpStatus.OK);
    }
}
