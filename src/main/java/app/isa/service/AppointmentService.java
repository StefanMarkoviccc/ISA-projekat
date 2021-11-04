package app.isa.service;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.model.Appointement;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.model.Appointement;
import org.springframework.stereotype.Service;
import java.util.List;

public interface AppointmentService {

    Appointement add(AppointmentDTO appointmentDTO);
    boolean deleted(Long id);
    List<Appointement> getList();
    Appointement getAppointment(Long id);
    Appointement edit(Long id, AppointmentDTO appointmentDTO);
}
