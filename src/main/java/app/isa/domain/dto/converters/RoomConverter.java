package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.BoatDTO;
import app.isa.domain.dto.DTO.RoomDTO;
import app.isa.domain.model.Boat;
import app.isa.domain.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomConverter {
    public  static Room fromDTO(RoomDTO roomDTO){

        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setNumberOfBeds(roomDTO.getNumberOfBeds());
        room.setHouse(null);

        return room;
    }

    public static  RoomDTO toDTO(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setNumberOfBeds(room.getNumberOfBeds());
        roomDTO.setHouseId(room.getHouse().getId());

        return roomDTO;
    }

    public  static List<RoomDTO> toDTOList(List<Room> rooms){
        ArrayList<RoomDTO> roomDTOList = new ArrayList<>();
        for(Room room : rooms){

            roomDTOList.add(toDTO(room));
        }
        return  roomDTOList;
    }
}
