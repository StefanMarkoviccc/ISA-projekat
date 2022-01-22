package app.isa.service;

import app.isa.domain.dto.DTO.ComplainDTO;
import app.isa.domain.dto.converters.ComplainConverter;
import app.isa.domain.model.Appointment;
import app.isa.domain.model.Complain;
import app.isa.domain.model.User;
import app.isa.domain.model.UserType;
import app.isa.repository.ComplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ComplainServiceImplementation implements ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    public Complain getComplain(Long id){
        Optional<Complain> complain = complainRepository.findById(id);
        if(complain.isEmpty()){
            return null;
        }
        return  complain.get();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Complain add(ComplainDTO complainDTO){
        Complain complain = ComplainConverter.fromDTO(complainDTO);

        List<Appointment> appointments;
        User user = userService.getUser(complain.getUserId());
        if(user.getUserType()== UserType.CLIENT){
           appointments = appointmentService.getByUserAndDelete(user.getId());
           for(Appointment appointment : appointments){
               if(appointment.getHouse().getId()!=complainDTO.getHouseId()) {
                   return null;
               }
           }
        }
        return complainRepository.save(complain);
    }

    public List<Complain> getList() { return  complainRepository.findAll();}
}
