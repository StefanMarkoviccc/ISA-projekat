package app.isa.controller;

import app.isa.domain.model.House;
import app.isa.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    //@GetMapping
   // public ResponseEntity<List<>>
}
