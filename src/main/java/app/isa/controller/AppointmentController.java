package app.isa.controller;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.dto.converters.AppointmentConverter;
import app.isa.domain.model.Appointement;
import app.isa.domain.model.House;
import app.isa.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAppointments(){
        return new ResponseEntity<List<AppointmentDTO>>(AppointmentConverter.toDTOList(appointmentService.getList()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long id){
        Appointement appointement = appointmentService.getAppointment(id);

        if(appointement == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AppointmentDTO>(AppointmentConverter.toDTO(appointement), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AppointmentDTO> edit(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO){
        Appointement appointement = appointmentService.edit(id,appointmentDTO);
        if (appointement == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AppointmentDTO>(AppointmentConverter.toDTO(appointement), HttpStatus.CREATED);
    }

}
