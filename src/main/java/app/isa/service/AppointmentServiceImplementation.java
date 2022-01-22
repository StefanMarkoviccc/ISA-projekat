package app.isa.service;

import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.dto.DTO.HouseAvailabilityPeriodDTO;
import app.isa.domain.dto.converters.AppointmentConverter;
import app.isa.domain.model.Appointment;
import app.isa.domain.model.House;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.domain.model.Room;
import app.isa.domain.model.User;
import app.isa.repository.AppointmentRepository;
import app.isa.repository.HouseAvailabilityPeriodRepository;
import app.isa.repository.HouseRepository;
import app.isa.repository.RoomRepository;
import app.isa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class AppointmentServiceImplementation implements AppointmentService{

    @Autowired
    private HouseAvailabilityPeriodService houseAvailabilityPeriodService;

    @Autowired
    private HouseAvailabilityPeriodRepository houseAvailabilityPeriodRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Appointment add(AppointmentDTO appointmentDTO){
        Appointment appointment = AppointmentConverter.fromDTO(appointmentDTO);
        Optional<House> house = houseRepository.findById(appointmentDTO.getHouseId());
        appointment.setHouse(house.get());
        Optional<Room> room = roomRepository.findById(appointmentDTO.getRoomId());
        appointment.setRoom(room.get());


        if(appointmentDTO.getClientId() != null) {
            Optional<User> user = userRepository.findById(appointmentDTO.getClientId());
            appointment.setClient(user.get());
        }

        if(appointmentDTO.isAction()){
            appointment.setAction(true);
            appointment.setTaken(false);
            appointment.setPriceForAction(appointmentDTO.getPrice());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(appointmentDTO.getDate());

        calendar.add(Calendar.DAY_OF_WEEK, appointmentDTO.getDuration());

        Date dateT0 = calendar.getTime();
        Date dateFrom = appointment.getAppointmentDate();

        List<HouseAvailabilityPeriod> periods = houseAvailabilityPeriodRepository.getAllByHouseAndDeleted((houseRepository.findById(appointmentDTO.getHouseId()).get()), false);

        if(periods.isEmpty() && !appointment.isAction()){
            return null;
        } else {
            for(HouseAvailabilityPeriod period:periods){

                if(!appointment.getHouse().getId().equals(appointment.getHouse().getId())) {
                    continue;
                }

                if(dateFrom.after(period.getDateFrom()) && dateT0.before(period.getDateTo())) {
                    period.setDeleted(true);
                } else {
                    return null;
                }


            }
        }


        if(appointmentDTO.isAction()){
            emailService.sendActionEmail(userService.getCliens());
        }

        return appointmentRepository.save(appointment);
    }

    public  boolean deleted(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if (appointment.isEmpty()) {
            return false;
        }

        appointment.get().setDeleted(true);
        appointmentRepository.save(appointment.get());
        return true;
    }
    @Override
    public List<Appointment> getList() {
        return  appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointment(Long id) {

        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if(appointment.isEmpty()){
            return null;
        }

        return appointment.get();
    }

    @Override
    public Appointment edit(Long id, AppointmentDTO appointmentDTO) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if(appointment.isEmpty()){
            return null;
        }
        Appointment appointment1 = AppointmentConverter.fromDTO(appointmentDTO);

        appointment.get().setAction(appointment1.isAction());
        appointment.get().setMaxPersons(appointment1.getMaxPersons());
        appointment.get().setAppointmentDate(appointment1.getAppointmentDate());
        appointment.get().setDeleted(appointment1.isDeleted());
        appointment.get().setDuration(appointment1.getDuration());
        appointment.get().setPrice(appointment1.getPrice());
        appointment.get().setHouse(appointment1.getHouse());
        appointment.get().setRoom(appointment1.getRoom());

        return appointmentRepository.save(appointment.get());
    }

    @Override
    public List<Appointment> getByUser(Long id) {
        return appointmentRepository.getByClient(userRepository.getById(id));
    }

    @Override
    public List<Appointment> getByHouse(Long id) {

        List<Appointment> appointments = new ArrayList<Appointment>();

        for(Appointment a: appointmentRepository.getByHouse(houseRepository.getById(id))){
            if(!a.isAction()){
                appointments.add(a);
            }
        }
        return appointments;
    }

    @Override
    public List<Appointment> getActionsByHouse(Long id) {

        List<Appointment> actions = new ArrayList<Appointment>();

        for (Appointment a: appointmentRepository.getAllByHouseAndDeleted(houseRepository.findById(id).get(), false)){
            if(a.isAction())
            {
                actions.add(a);
            }
        }
        return actions;
    }

    @Override
    public boolean isReservationFinished(Long id) {

        Appointment a = appointmentRepository.findById(id).get();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(a.getAppointmentDate());

        calendar.add(Calendar.DAY_OF_WEEK, a.getDuration());

        Date dateT0 = calendar.getTime();
        Date dateFrom = a.getAppointmentDate();


        if(dateT0.after(Calendar.getInstance().getTime())){
            return true;
        }

        return false;
    }
}
