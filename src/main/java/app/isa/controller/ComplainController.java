package app.isa.controller;


import app.isa.domain.dto.DTO.ComplainDTO;
import app.isa.domain.dto.converters.ComplainConverter;
import app.isa.domain.model.Appointment;
import app.isa.domain.model.Complain;
import app.isa.domain.model.User;
import app.isa.domain.model.UserType;
import app.isa.service.AppointmentService;
import app.isa.service.ComplainService;
import app.isa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/complains")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<ComplainDTO>> getComplains(){
        return new ResponseEntity<List<ComplainDTO>>(ComplainConverter.toDTOList(complainService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ComplainDTO> getComplain(@PathVariable Long id){
        Complain complain = complainService.getComplain(id);
        if(complain==null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ComplainDTO>(ComplainConverter.toDTO(complain),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ComplainDTO> add(@RequestBody ComplainDTO complainDTO){
        Complain complain = complainService.add(complainDTO);

        if(complain == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ComplainConverter.toDTO(complain),HttpStatus.CREATED);
    }

}
