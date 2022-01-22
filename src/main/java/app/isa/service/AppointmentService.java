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
    List<Appointment> getByUserAndDelete(Long id);
    List<Appointment> getByHouse(Long id);
    List<Appointment> getActionsByHouse(Long id);
    List<Appointment> getActions();
    boolean isReservationFinished(Long id);
    Appointment reservAction(Long id);
}
