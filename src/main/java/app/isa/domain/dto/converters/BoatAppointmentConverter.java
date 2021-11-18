package app.isa.domain.dto.converters;

import app.isa.domain.dto.BoatAppointmentDTO;
import app.isa.domain.model.BoatAppointment;

import java.util.ArrayList;
import java.util.List;

public class BoatAppointmentConverter {

    public static BoatAppointment fromDTO(BoatAppointmentDTO boatAppointmentDTO ){
        BoatAppointment boatAppointment = new BoatAppointment();
        boatAppointment.setId(boatAppointmentDTO.getId());
        boatAppointment.setAction(boatAppointmentDTO.isAction());
        boatAppointment.setDate(boatAppointmentDTO.getDate());
        boatAppointment.setDuration(boatAppointmentDTO.getDuration());
        boatAppointment.setMaxPersons(boatAppointmentDTO.getMaxPersons());
        boatAppointment.setPrice(boatAppointmentDTO.getPrice());
        boatAppointment.setBoat(null);

        return  boatAppointment;
    }

    public static BoatAppointmentDTO toDTO(BoatAppointment boatAppointment){
        BoatAppointmentDTO boatAppointmentDTO= new BoatAppointmentDTO();

        boatAppointmentDTO.setId(boatAppointment.getId());
        boatAppointmentDTO.setBoatID(boatAppointment.getBoat().getId());
        boatAppointmentDTO.setDate(boatAppointment.getDate());
        boatAppointmentDTO.setAction(boatAppointment.isAction());
        boatAppointmentDTO.setDuration(boatAppointment.getDuration());
        boatAppointmentDTO.setMaxPersons(boatAppointment.getMaxPersons());
        boatAppointmentDTO.setPrice(boatAppointment.getPrice());

        return boatAppointmentDTO;
    }

    public static List<BoatAppointmentDTO> toDTOList(List<BoatAppointment> boatAppointments){
        ArrayList<BoatAppointmentDTO> boatAppointmentDTOList = new ArrayList<>();
        for(BoatAppointment boatAppointment:boatAppointments){
            boatAppointmentDTOList.add(toDTO(boatAppointment));
        }
        return  boatAppointmentDTOList;
    }
}
