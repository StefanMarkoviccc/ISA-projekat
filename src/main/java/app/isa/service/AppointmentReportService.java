package app.isa.service;

import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.dto.DTO.AppointmentReportDTO;
import app.isa.domain.model.Appointment;
import app.isa.domain.model.AppointmentReport;

import java.util.List;

public interface AppointmentReportService {

    AppointmentReport add(AppointmentReportDTO appointmentReportDTO);
    boolean deleted(Long id);
    List<AppointmentReport> getList();
    AppointmentReport getAppointmentReport(Long id);
}
