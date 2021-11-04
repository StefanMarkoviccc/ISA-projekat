package app.isa.domain.dto.converters;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.model.Appointement;

import java.util.ArrayList;
import java.util.List;

public class AppointmentConverter {

    public static AppointmentDTO toDTO(Appointement appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setHouseId(appointment.getHouse().getId());
        appointmentDTO.setRoomId(appointment.getRoom().getId());
        appointmentDTO.setDate(appointment.getDate());
        appointmentDTO.setAction(appointment.isAction());
        appointmentDTO.setDuration(appointment.getDuration());
        appointmentDTO.setMaxPersons(appointment.getMaxPersons());
        appointmentDTO.setPrice(appointment.getPrice());

        return appointmentDTO;
    }

    public static List<AppointmentDTO> toDTOList(List<Appointement> appointements){
        ArrayList<AppointmentDTO> appointmentDTOList = new ArrayList<AppointmentDTO>();
        for(Appointement appointement : appointements){
            appointmentDTOList.add(toDTO(appointement));
        }
        return  appointmentDTOList;
    }
}
