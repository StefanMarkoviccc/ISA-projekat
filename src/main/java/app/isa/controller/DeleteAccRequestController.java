package app.isa.controller;

import app.isa.domain.dto.DTO.DeleteAccRequestDTO;
import app.isa.domain.dto.converters.DeleteAccRequestConverter;
import app.isa.domain.model.DeleteAccRequest;
import app.isa.service.DeleteAccRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accRequests")
public class DeleteAccRequestController {

    @Autowired
    private DeleteAccRequestService deleteAccRequestService;

    @GetMapping
    public ResponseEntity<List<DeleteAccRequestDTO>> getDeleteAccRequests(){
        return new ResponseEntity<List<DeleteAccRequestDTO>>(DeleteAccRequestConverter.toDTOList(deleteAccRequestService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeleteAccRequestDTO> getDeleteAccRequest(@PathVariable Long id){
        DeleteAccRequest deleteAccRequest = deleteAccRequestService.getDeleteAccRequest(id);
        if(deleteAccRequest==null){
            return new ResponseEntity<DeleteAccRequestDTO>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<DeleteAccRequestDTO>(DeleteAccRequestConverter.toDTO(deleteAccRequest),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeleteAccRequestDTO> add(@RequestBody DeleteAccRequestDTO deleteAccRequestDTO){
        DeleteAccRequest deleteAccRequest = deleteAccRequestService.add(deleteAccRequestDTO);
        if(deleteAccRequest==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(DeleteAccRequestConverter.toDTO(deleteAccRequest),HttpStatus.CREATED);
    }
}
