package app.isa.controller;

import app.isa.domain.dto.DTO.HouseImageDTO;
import app.isa.domain.dto.converters.HouseImageConverter;
import app.isa.domain.model.HouseImage;
import app.isa.service.HouseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/houseImages")
public class HouseImageController {

    @Autowired
    private HouseImageService houseImageService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<HouseImageDTO>> getHouseImages(@PathVariable Long id){
        return new ResponseEntity<List<HouseImageDTO>>(HouseImageConverter.toDTOList(houseImageService.getList(id)), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<HouseImageDTO> add(@RequestBody HouseImageDTO houseImageDTO){
        HouseImage houseImage= houseImageService.add(houseImageDTO);

        if(houseImage==null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(HouseImageConverter.toDTO(houseImage), HttpStatus.CREATED);
    }
}
