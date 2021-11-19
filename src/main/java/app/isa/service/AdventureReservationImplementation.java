package app.isa.service;

import app.isa.domain.dto.DTO.AdventureReservationDTO;
import app.isa.domain.dto.converters.AdventureReservationConverter;
import app.isa.domain.dto.converters.AppointmentConverter;
import app.isa.domain.model.AdventureReservation;
import app.isa.domain.model.Appointment;
import app.isa.domain.model.House;
import app.isa.domain.model.Room;
import app.isa.repository.AdventureReservationRepository;
import app.isa.repository.HouseRepository;
import app.isa.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdventureReservationImplementation implements  AdventureReservationService{

    @Autowired
    private AdventureReservationRepository adventureReservationRepository;


    public AdventureReservation add(AdventureReservationDTO adventureReservationDTO) {
        AdventureReservation adventureReservation = AdventureReservationConverter.fromDTO(adventureReservationDTO);
        adventureReservation.setPlace(adventureReservationDTO.getPlace());
        adventureReservation.setDuration(adventureReservationDTO.getDuration());
        adventureReservation.setAdditionalServices(adventureReservationDTO.getAdditionalServices());
        adventureReservation.setDateAndTime(adventureReservationDTO.getDateAndTime());
        adventureReservation.setMaximumNumberOfPersons(adventureReservationDTO.getMaximumNumberOfPersons());

        return adventureReservationRepository.save(adventureReservation);
    }

    public boolean deleted(Long id) {
        Optional<AdventureReservation> adventureReservation = adventureReservationRepository.findById(id);

        if (adventureReservation.isEmpty()) {
            return false;
        }

        adventureReservation.get().setDeleted(true);
        adventureReservationRepository.save(adventureReservation.get());
        return true;
    }

    @Override
    public List<AdventureReservation> getList() {
        return adventureReservationRepository.findAll();
    }

    @Override
    public AdventureReservation getAdventureReservation(Long id) {

        Optional<AdventureReservation> adventureReservation = adventureReservationRepository.findById(id);

        if (adventureReservation.isEmpty()) {
            return null;
        }

        return adventureReservation.get();
    }

    @Override
    public AdventureReservation edit(Long id, AdventureReservationDTO adventureReservationDTO) {
        Optional<AdventureReservation> adventureReservationDB = adventureReservationRepository.findById(id);

        if (adventureReservationDB.isEmpty()) {
            return null;
        }
        AdventureReservation adventureReservation = AdventureReservationConverter.fromDTO(adventureReservationDTO);

        adventureReservationDB.get().setDeleted(adventureReservation.isDeleted());
        adventureReservationDB.get().setDuration(adventureReservation.getDuration());
        adventureReservationDB.get().setPlace(adventureReservation.getPlace());
        adventureReservationDB.get().setPrice(adventureReservation.getPrice());
        adventureReservationDB.get().setDateAndTime(adventureReservation.getDateAndTime());
        adventureReservationDB.get().setMaximumNumberOfPersons(adventureReservation.getMaximumNumberOfPersons());
        adventureReservationDB.get().setAdditionalServices(adventureReservation.getAdditionalServices());

        return adventureReservationRepository.save(adventureReservationDB.get());
    }
}
