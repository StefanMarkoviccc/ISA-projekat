package app.isa.service;

import app.isa.domain.dto.BoatAppointmentDTO;
import app.isa.domain.model.BoatAppointment;

import java.util.List;

public interface BoatAppointmentService {

    List<BoatAppointment> getList();
    BoatAppointment getBoatAppointment(Long id);
    BoatAppointment add(BoatAppointmentDTO boatAppointmentDTO);
}
