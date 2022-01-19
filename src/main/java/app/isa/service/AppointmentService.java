package app.isa.service;

import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment add(AppointmentDTO appointmentDTO);
    boolean deleted(Long id);
    List<Appointment> getList();
    Appointment getAppointment(Long id);
    Appointment edit(Long id, AppointmentDTO appointmentDTO);
    List<Appointment> getByUser(Long id);
    List<Appointment> getByHouse(Long id);
    List<Appointment> getActionsByHouse(Long id);
    boolean isReservationFinished(Long id);
}
