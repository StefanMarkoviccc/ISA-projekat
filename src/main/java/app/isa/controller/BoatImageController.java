package app.isa.controller;

import app.isa.domain.dto.DTO.BoatImageDTO;
import app.isa.domain.dto.converters.BoatImageConverter;
import app.isa.domain.model.BoatImage;
import app.isa.service.BoatImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/boatImages")
public class BoatImageController {

    @Autowired
    private BoatImageService boatImageService;

    @GetMapping(path="/{id}")
    public ResponseEntity<List<BoatImageDTO>> getBoatImages(@PathVariable Long id){
        return new ResponseEntity<List<BoatImageDTO>>(BoatImageConverter.toDTOList(boatImageService.getList(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoatImageDTO> add(@RequestBody BoatImageDTO boatImageDTO){
        BoatImage boatImage = boatImageService.add(boatImageDTO);

        if(boatImage==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(BoatImageConverter.toDTO(boatImage), HttpStatus.CREATED);
    }
}
