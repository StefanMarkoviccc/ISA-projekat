package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentConverter {

    public static Appointment fromDTO(AppointmentDTO appointmentDTO) {

        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setAction(appointmentDTO.isAction());
        appointment.setAppointmentDate(appointmentDTO.getDate());
        appointment.setDuration(appointmentDTO.getDuration());
        appointment.setMaxPersons(appointmentDTO.getMaxPersons());
        appointment.setPrice(appointmentDTO.getPrice());

        appointment.setPriceForAction(appointmentDTO.getPriceForAction());
        appointment.setTaken(appointmentDTO.isTaken());
        appointment.setClient(null);
        appointment.setHouse(null);
        appointment.setRoom(null);

        return appointment;
    }

    public static AppointmentDTO toDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setHouseId(appointment.getHouse().getId());
        appointmentDTO.setRoomId(appointment.getRoom().getId());
        appointmentDTO.setDate(appointment.getAppointmentDate());
        appointmentDTO.setAction(appointment.isAction());
        appointmentDTO.setDuration(appointment.getDuration());
        appointmentDTO.setMaxPersons(appointment.getMaxPersons());
        appointmentDTO.setPrice(appointment.getPrice());

        appointmentDTO.setTaken(appointment.isTaken());
        appointmentDTO.setPriceForAction(appointment.getPriceForAction());

        if(appointment.getClient() != null && appointment.getClient().getId()!=null)
        {
            appointmentDTO.setClientId(appointment.getClient().getId());
            appointmentDTO.setHouse(appointment.getHouse());
        }


        return appointmentDTO;
    }

    public static List<AppointmentDTO> toDTOList(List<Appointment> appointments){
        ArrayList<AppointmentDTO> appointmentDTOList = new ArrayList<AppointmentDTO>();
        for(Appointment appointment : appointments){
            appointmentDTOList.add(toDTO(appointment));
        }
        return  appointmentDTOList;
    }
}
