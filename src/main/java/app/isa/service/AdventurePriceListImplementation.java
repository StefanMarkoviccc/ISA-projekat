package app.isa.service;

import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.dto.converters.AppointmentConverter;
import app.isa.domain.model.Appointment;
import app.isa.domain.model.House;
import app.isa.domain.model.Room;
import app.isa.repository.AppointmentRepository;
import app.isa.repository.HouseRepository;
import app.isa.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdventurePriceListImplementation implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Appointment add(AppointmentDTO appointmentDTO) {
        Appointment appointment = AppointmentConverter.fromDTO(appointmentDTO);
        Optional<House> house = houseRepository.findById(appointmentDTO.getHouseId());
        appointment.setHouse(house.get());
        Optional<Room> room = roomRepository.findById(appointmentDTO.getRoomId());
        appointment.setRoom(room.get());
        return appointmentRepository.save(appointment);
    }

    public boolean deleted(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if (appointment.isEmpty()) {
            return false;
        }

        appointment.get().setDeleted(true);
        appointmentRepository.save(appointment.get());
        return true;
    }

    @Override
    public List<Appointment> getList() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointment(Long id) {

        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if (appointment.isEmpty()) {
            return null;
        }

        return appointment.get();
    }

    @Override
    public Appointment edit(Long id, AppointmentDTO appointmentDTO) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if (appointment.isEmpty()) {
            return null;
        }
        Appointment appointment1 = AppointmentConverter.fromDTO(appointmentDTO);

        appointment.get().setAction(appointment1.isAction());
        appointment.get().setMaxPersons(appointment1.getMaxPersons());
        appointment.get().setAppointmentDate(appointment1.getAppointmentDate());
        appointment.get().setDeleted(appointment1.isDeleted());
        appointment.get().setDuration(appointment1.getDuration());
        appointment.get().setPrice(appointment1.getPrice());
        appointment.get().setHouse(appointment1.getHouse());
        appointment.get().setRoom(appointment1.getRoom());

        return appointmentRepository.save(appointment.get());
    }
}
