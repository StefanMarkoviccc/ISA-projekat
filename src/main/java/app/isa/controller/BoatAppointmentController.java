package app.isa.controller;


import app.isa.domain.dto.DTO.BoatAppointmentDTO;
import app.isa.domain.dto.converters.BoatAppointmentConverter;
import app.isa.domain.model.BoatAppointment;
import app.isa.service.BoatAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/boatAppointments")

public class BoatAppointmentController {

    @Autowired
    private BoatAppointmentService boatAppointmentService;

    @GetMapping
    public ResponseEntity<List<BoatAppointmentDTO>> getBoatAppointments(){
        return new ResponseEntity<List<BoatAppointmentDTO>>(BoatAppointmentConverter.toDTOList(boatAppointmentService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BoatAppointmentDTO> getBoatAppointments(@PathVariable Long id){

        BoatAppointment boatAppointment = boatAppointmentService.getBoatAppointment(id);
        if (boatAppointment == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<BoatAppointmentDTO>(BoatAppointmentConverter.toDTO(boatAppointment),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoatAppointmentDTO> add(@RequestBody BoatAppointmentDTO boatAppointmentDTO){
        BoatAppointment boatAppointment = boatAppointmentService.add(boatAppointmentDTO);

        if(boatAppointment == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(BoatAppointmentConverter.toDTO(boatAppointment),HttpStatus.CREATED);
    }
}
