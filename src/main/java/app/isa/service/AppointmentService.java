package app.isa.service;


import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.model.Appointement;
import org.springframework.stereotype.Service;


public interface AppointmentService {

    Appointement add(AppointmentDTO appointmentDTO);
    boolean deleted(Long id);
}
