package app.isa.service;

import app.isa.domain.dto.DTO.BoatAppointmentDTO;
import app.isa.domain.dto.converters.BoatAppointmentConverter;
import app.isa.domain.model.*;
import app.isa.repository.BoatAppointmentRepository;
import app.isa.repository.BoatAvailabilityPeriodRepository;
import app.isa.repository.BoatRepository;
import app.isa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoatAppointmentServiceImplementation implements BoatAppointmentService{

    @Autowired
    private BoatAppointmentRepository boatAppointmentRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private BoatAvailabilityPeriodRepository boatAvailabilityPeriodRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BoatAppointment> getList() {
        return boatAppointmentRepository.findAll();
    }

    @Override
    public BoatAppointment getBoatAppointment(Long id) {
        Optional<BoatAppointment> boatAppointment = boatAppointmentRepository.findById(id);

        if(boatAppointment.isEmpty()){
            return  null;
        }

        return boatAppointment.get();
    }

    @Override
    public BoatAppointment add(BoatAppointmentDTO boatAppointmentDTO) {
        BoatAppointment boatAppointment = BoatAppointmentConverter.fromDTO(boatAppointmentDTO);
        Optional<Boat> boat = boatRepository.findById(boatAppointmentDTO.getBoatId());
        boatAppointment.setBoat(boat.get());

        if(boatAppointmentDTO.getClientId() != null) {
            Optional<User> user = userRepository.findById(boatAppointmentDTO.getClientId());
            boatAppointment.setClient(user.get());
        }

        if(boatAppointmentDTO.isAction()){
            boatAppointment.setAction(true);
            boatAppointment.setTaken(false);
            boatAppointment.setPriceForAction(boatAppointmentDTO.getPrice());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(boatAppointmentDTO.getDate());

        calendar.add(Calendar.DAY_OF_WEEK, boatAppointmentDTO.getDuration());

        Date dateT0 = calendar.getTime();
        Date dateFrom = boatAppointment.getDate();

        List<BoatAvailabilityPeriod> periods = boatAvailabilityPeriodRepository.getAllByBoatAndDeleted((boatRepository.findById(boatAppointmentDTO.getBoatId()).get()), false);

        if(periods.isEmpty() && !boatAppointment.isAction()){
            return null;
        } else {
            for(BoatAvailabilityPeriod period:periods){

                if(!boatAppointment.getBoat().getId().equals(boatAppointment.getBoat().getId())) {
                    continue;
                }

                if(dateFrom.after(period.getDateFrom()) && dateT0.before(period.getDateTo())) {
                    period.setDeleted(true);
                } else {
                    return null;
                }


            }
        }


        if(boatAppointmentDTO.isAction()){
            emailService.sendActionEmail(userService.getCliens());
        }

        return boatAppointmentRepository.save(boatAppointment);
    }
}