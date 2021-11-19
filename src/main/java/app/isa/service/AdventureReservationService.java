package app.isa.service;

import app.isa.domain.dto.DTO.AdventureReservationDTO;
import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.model.AdventureReservation;
import app.isa.domain.model.Appointment;

import java.util.List;

public interface AdventureReservationService {

    AdventureReservation add(AdventureReservationDTO adventureReservationDTO);
    boolean deleted(Long id);
    List<AdventureReservation> getList();
    AdventureReservation getAdventureReservation(Long id);
    AdventureReservation edit(Long id, AdventureReservationDTO adventureReservationDTO);

}
