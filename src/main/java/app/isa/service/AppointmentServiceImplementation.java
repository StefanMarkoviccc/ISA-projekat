package app.isa.service;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.dto.converters.AppointmentConverter;
import app.isa.domain.model.Appointement;
import app.isa.domain.model.House;
import app.isa.domain.model.Room;
import app.isa.repository.AppointmentRepository;
import app.isa.repository.HouseRepository;
import app.isa.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.isa.domain.model.Appointement;
import app.isa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Optional;


@Service
public class AppointmentServiceImplementation implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Appointement add(AppointmentDTO appointmentDTO){
        Appointement appointement = AppointmentConverter.fromDTO(appointmentDTO);
        Optional<House> house = houseRepository.findOne(appointmentDTO.getHouseId());
        appointement.setHouse(house.get());
        Optional<Room> room = roomRepository.findOne(appointmentDTO.getRoomId());
        appointement.setRoom(room.get());
        return appointmentRepository.save(appointement);
    }

    public  boolean deleted(Long id) {
        Optional<Appointement> appointement = appointmentRepository.findOne(id);

        if (appointement.isEmpty()) {
            return false;
        }

        appointement.get().setDeleted(true);
        appointmentRepository.save(appointement.get());
        return true;
    }
    @Override
    public List<Appointement> getList() {
        return  appointmentRepository.getAll();
    }

    @Override
    public Appointement getAppointment(Long id) {

        Optional<Appointement> appointement = appointmentRepository.findOne(id);

        if(appointement.isEmpty()){
            return null;
        }

        return appointement.get();
    }

    @Override
    public Appointement edit(Long id, AppointmentDTO appointmentDTO) {
        Optional<Appointement> appointement = appointmentRepository.findOne(id);

        if(appointement.isEmpty()){
            return null;
        }
        Appointement appointement1 = AppointmentConverter.fromDTO(appointmentDTO);

        appointement.get().setAction(appointement1.isAction());
        appointement.get().setMaxPersons(appointement1.getMaxPersons());
        appointement.get().setDate(appointement1.getDate());
        appointement.get().setDeleted(appointement1.isDeleted());
        appointement.get().setDuration(appointement1.getDuration());
        appointement.get().setPrice(appointement1.getPrice());
        appointement.get().setHouse(appointement1.getHouse());
        appointement.get().setRoom(appointement1.getRoom());

        return appointmentRepository.save(appointement.get());
    }
}
