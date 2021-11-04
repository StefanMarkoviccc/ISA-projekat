package app.isa.service;

import app.isa.domain.dto.AppointmentDTO;
import app.isa.domain.model.Appointement;
import app.isa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImplementation implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

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
        return null;
    }
}
