package app.isa.service;

import app.isa.domain.dto.DTO.RoomDTO;
import app.isa.domain.dto.converters.RoomConverter;
import app.isa.domain.model.Room;
import app.isa.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImplementation {
    @Autowired
    private RoomRepository roomRepository;


    public List<Room> getList() {
        return roomRepository.findAll();
    }


    public Room getBoat(Long id) {
        Optional<Room> room = roomRepository.findById(id);

        if(room.isEmpty()){
            return  null;
        }
        return  room.get();
    }


    public Room edit(Long id, RoomDTO roomDTO) {
        Optional<Room> room = roomRepository.findById(id);

        if(room.isEmpty()){
            return  null;
        }

        Room roomData = RoomConverter.fromDTO(roomDTO);

        room.get().setRoomNumber(roomData.getRoomNumber());
        room.get().setNumberOfBeds(roomData.getNumberOfBeds());
        room.get().setHouse(roomData.getHouse());
        room.get().setDeleted(roomData.isDeleted());


        return  roomRepository.save(room.get());
    }


    public Room add(RoomDTO roomDTO) {
        Room room= RoomConverter.fromDTO(roomDTO);
        return roomRepository.save(room);
    }


    public boolean deleted(Long id) {

        Optional<Room> room = roomRepository.findById(id);

        if(room.isEmpty()){
            return  false;
        }

        room.get().setDeleted(true);
        roomRepository.save(room.get());

        return true;
    }
}
