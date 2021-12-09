package app.isa.controller;

import app.isa.domain.dto.DTO.RoomDTO;
import app.isa.domain.dto.converters.RoomConverter;
import app.isa.domain.model.Room;
import app.isa.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getRooms(){
        return new ResponseEntity<List<RoomDTO>>(RoomConverter.toDTOList(roomService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RoomDTO> getRoom(@PathVariable Long id){

        Room room = roomService.getRoom(id);
        if (room == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<RoomDTO>(RoomConverter.toDTO(room),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> add(@RequestBody RoomDTO roomDTO){
        Room room = roomService.add(roomDTO);

        if(room == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(RoomConverter.toDTO(room),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RoomDTO> edit(@PathVariable Long id, @RequestBody RoomDTO roomDTO){
        Room room = roomService.edit(id,roomDTO);

        if(room == null){
            return  new ResponseEntity<RoomDTO>(RoomConverter.toDTO(room), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<RoomDTO>(RoomConverter.toDTO(room), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(roomService.deleted(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
