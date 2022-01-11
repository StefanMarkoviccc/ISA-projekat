package app.isa.service;

import app.isa.domain.dto.DTO.ComplainDTO;
import app.isa.domain.dto.converters.ComplainConverter;
import app.isa.domain.model.Complain;
import app.isa.repository.ComplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplainServiceImplementation implements ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    public Complain getComplain(Long id){
        Optional<Complain> complain = complainRepository.findById(id);
        if(complain.isEmpty()){
            return null;
        }
        return  complain.get();
    }

    public Complain add(ComplainDTO complainDTO){
        Complain complain = ComplainConverter.fromDTO(complainDTO);
        return complainRepository.save(complain);
    }

    public List<Complain> getList() { return  complainRepository.findAll();}
}
