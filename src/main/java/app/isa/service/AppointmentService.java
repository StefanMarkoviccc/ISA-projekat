package app.isa.service;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.model.Appointement;

import java.util.List;

public interface AppointmentService {

    List<Appointement> getList();
    Appointement getAppointment(Long id);
    Appointement edit(Long id, AppointmentDTO appointmentDTO);
}
