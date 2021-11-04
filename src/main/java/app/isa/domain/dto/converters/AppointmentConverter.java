package app.isa.domain.dto.converters;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.model.Appointement;
import app.isa.domain.model.House;
import app.isa.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class AppointmentConverter {

    public static Appointement fromDTO(AppointmentDTO appointmentDTO) {

        Appointement appointment = new Appointement();
        appointment.setId(appointmentDTO.getId());
        appointment.setAction(appointmentDTO.isAction());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setDuration(appointmentDTO.getDuration());
        appointment.setMaxPersons(appointmentDTO.getMaxPersons());
        appointment.setPrice(appointmentDTO.getPrice());
        appointment.setHouse(null);
        appointment.setRoom(null);

        return appointment;
    }

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
