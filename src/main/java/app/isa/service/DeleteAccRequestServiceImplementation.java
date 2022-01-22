package app.isa.service;

import app.isa.domain.dto.DTO.DeleteAccRequestDTO;
import app.isa.domain.dto.converters.DeleteAccRequestConverter;
import app.isa.domain.model.DeleteAccRequest;
import app.isa.domain.model.User;
import app.isa.repository.DeleteAccRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeleteAccRequestServiceImplementation implements DeleteAccRequestService{

    @Autowired
    private DeleteAccRequestRepository deleteAccRequestRepository;

    @Autowired
    private UserService  userService;

    public DeleteAccRequest getDeleteAccRequest(Long id){
        Optional<DeleteAccRequest> request = deleteAccRequestRepository.findById(id);
        if(request.isEmpty()){
            return null;
        }
        return request.get();
    }

    public DeleteAccRequest add(DeleteAccRequestDTO deleteAccRequestDTO){
        DeleteAccRequest deleteAccRequest = DeleteAccRequestConverter.fromDTO(deleteAccRequestDTO);
    return deleteAccRequestRepository.save(deleteAccRequest);
    }

    public List<DeleteAccRequest> getList() {return deleteAccRequestRepository.findAll();}
}
