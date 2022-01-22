package app.isa.controller;

import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.dto.DTO.AppointmentReportDTO;
import app.isa.domain.dto.converters.ActionHouseConverter;
import app.isa.domain.dto.converters.AppointmentReposrtConverter;
import app.isa.domain.model.ActionHouse;
import app.isa.domain.model.AppointmentReport;
import app.isa.service.AppointmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appointmentReports")

public class AppointmentReportController {

    @Autowired
    private AppointmentReportService appointmentReportService;

    @GetMapping
    public ResponseEntity<List<AppointmentReportDTO>> getAppointmentReports(){
        return new ResponseEntity<List<AppointmentReportDTO>>(AppointmentReposrtConverter.toDTOList(appointmentReportService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AppointmentReportDTO> getAppointmentReport(@PathVariable Long id){

        AppointmentReport appointmentReport = appointmentReportService.getAppointmentReport(id);
        if (appointmentReport == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AppointmentReportDTO>(AppointmentReposrtConverter.toDTO(appointmentReport),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<AppointmentReportDTO> add(@RequestBody AppointmentReportDTO appointmentReportDTO){
        AppointmentReport appointmentReport = appointmentReportService.add(appointmentReportDTO);

        if(appointmentReport == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(AppointmentReposrtConverter.toDTO(appointmentReport),HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(appointmentReportService.deleted(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
