package app.isa.service;

import app.isa.domain.dto.DTO.AdventureDTO;
import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.model.Adventure;
import app.isa.domain.model.Appointment;

import java.util.List;

public interface AdventureService {


    Adventure add(AdventureDTO adventureDTO);
    boolean deleted(Long id);
    List<Adventure> getList();
    Adventure getAdventure(Long id);
    Adventure edit(Long id, AdventureDTO adventureDTO);
}
