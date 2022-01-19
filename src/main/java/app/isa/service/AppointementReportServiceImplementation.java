package app.isa.service;

import app.isa.domain.dto.DTO.AppointmentReportDTO;
import app.isa.domain.dto.converters.ActionHouseConverter;
import app.isa.domain.dto.converters.AppointmentReposrtConverter;
import app.isa.domain.model.*;
import app.isa.repository.AppointmentReposrtRepository;
import app.isa.repository.HouseRepository;
import app.isa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointementReportServiceImplementation implements AppointmentReportService{

    @Autowired
    private AppointmentReposrtRepository appointmentReposrtRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppointmentReport add(AppointmentReportDTO appointmentReportDTO) {
        AppointmentReport appointmentReport = AppointmentReposrtConverter.fromDTO(appointmentReportDTO);
        Optional<House> house = houseRepository.findById(appointmentReportDTO.getHouseId());
        appointmentReport.setHouse(house.get());
        Optional<User> client = userRepository.findById(appointmentReportDTO.getClientId());
        appointmentReport.setClient(client.get());
        Optional<User> owner = userRepository.findById(appointmentReportDTO.getOwnerId());
        appointmentReport.setOwner(owner.get());
        return appointmentReposrtRepository.save(appointmentReport);
    }

    @Override
    public boolean deleted(Long id) {
        Optional<AppointmentReport> appointmentReport = appointmentReposrtRepository.findById(id);

        if(appointmentReport.isEmpty())
        {
            return false;
        }

        appointmentReport.get().setDeleted(true);
        appointmentReposrtRepository.save(appointmentReport.get());
        return true;
    }

    @Override
    public List<AppointmentReport> getList() {
        return appointmentReposrtRepository.findAll();
    }

    @Override
    public AppointmentReport getAppointmentReport(Long id) {
        Optional<AppointmentReport> appointmentReport = appointmentReposrtRepository.findById(id);

        if (appointmentReport.isEmpty()) {
            return null;
        }

        return appointmentReport.get();
    }
}
