package app.isa.controller;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.dto.converters.AppointmentConverter;
import app.isa.domain.model.Appointment;
import app.isa.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> add(@RequestBody AppointmentDTO appointmentDTO){
        Appointment appointment = appointmentService.add(appointmentDTO);

        if(appointment ==null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(AppointmentConverter.toDTO(appointment),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(appointmentService.deleted(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAppointments(){
        return new ResponseEntity<List<AppointmentDTO>>(AppointmentConverter.toDTOList(appointmentService.getList()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long id){
        Appointment appointment = appointmentService.getAppointment(id);

        if(appointment == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AppointmentDTO>(AppointmentConverter.toDTO(appointment), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AppointmentDTO> edit(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO){
        Appointment appointment = appointmentService.edit(id,appointmentDTO);
        if (appointment == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AppointmentDTO>(AppointmentConverter.toDTO(appointment), HttpStatus.CREATED);
    }
}
