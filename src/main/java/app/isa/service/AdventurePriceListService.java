package app.isa.service;

import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.model.Appointment;

import java.util.List;

public interface AdventurePriceListService {


    Appointment add(AppointmentDTO appointmentDTO);
    boolean deleted(Long id);
    List<Appointment> getList();
    Appointment getAppointment(Long id);
    Appointment edit(Long id, AppointmentDTO appointmentDTO);

}
