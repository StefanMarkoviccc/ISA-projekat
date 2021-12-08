package app.isa.service;

import app.isa.domain.dto.DTO.BoatDTO;
import app.isa.domain.dto.DTO.RoomDTO;
import app.isa.domain.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getList();
    Room  getRoom(Long id);
    Room edit(Long id, RoomDTO roomDTO);
    Room add(RoomDTO roomDTO);
    boolean deleted(Long id);
}
