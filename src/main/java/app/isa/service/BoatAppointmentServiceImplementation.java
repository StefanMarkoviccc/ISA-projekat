package app.isa.service;

import app.isa.domain.dto.DTO.BoatAppointmentDTO;
import app.isa.domain.dto.converters.BoatAppointmentConverter;
import app.isa.domain.model.BoatAppointment;
import app.isa.repository.BoatAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatAppointmentServiceImplementation implements BoatAppointmentService{

    @Autowired
    private BoatAppointmentRepository boatAppointmentRepository;

    @Override
    public List<BoatAppointment> getList() {
        return boatAppointmentRepository.getAll();
    }

    @Override
    public BoatAppointment getBoatAppointment(Long id) {
        Optional<BoatAppointment> boatAppointment = boatAppointmentRepository.findOne(id);

        if(boatAppointment.isEmpty()){
            return  null;
        }

        return boatAppointment.get();
    }

    @Override
    public BoatAppointment add(BoatAppointmentDTO boatAppointmentDTO) {
        BoatAppointment boatAppointment = BoatAppointmentConverter.fromDTO(boatAppointmentDTO);

        return boatAppointmentRepository.save(boatAppointment);
    }
}
