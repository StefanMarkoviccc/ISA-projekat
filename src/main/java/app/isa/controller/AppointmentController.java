package app.isa.controller;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.dto.converters.AppointmentConverter;
import app.isa.domain.dto.converters.HouseConverter;
import app.isa.domain.model.Appointement;
import app.isa.domain.model.House;
import app.isa.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> add(@RequestBody AppointmentDTO appointmentDTO){
        Appointement appointement = appointmentService.add(appointmentDTO);

        if(appointement==null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(AppointmentConverter.toDTO(appointement),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(appointmentService.deleted(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
