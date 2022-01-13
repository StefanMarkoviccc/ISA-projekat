package app.isa.service;

import app.isa.domain.model.Appointment;
import app.isa.domain.model.House;
import app.isa.domain.model.HouseAvailabilityPeriod;
import app.isa.repository.AppointmentRepository;
import app.isa.repository.HouseAvailabilityPeriodRepository;
import app.isa.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SearchHousesServiceImplementation implements SearchHousesService{

    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private HouseAvailabilityPeriodRepository houseAvailabilityPeriodRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<House> getBySearchDate(Date startDate, Date endDate) {
        List<House> results = new ArrayList<>();


        for(HouseAvailabilityPeriod hap : houseAvailabilityPeriodRepository.findAll()){

            if(!(startDate.after(hap.getDateFrom()) && endDate.before(hap.getDateTo()))) {
                continue;
            }

            if(isAlreadyTaken(hap.getHouse(), startDate, endDate)) {
                continue;
            }

            results.add(hap.getHouse());
        }
        return results;
    }

    private boolean isAlreadyTaken(House house, Date startDate, Date endDate) {

        for(Appointment app: appointmentRepository.findAll()) {

            if(!app.getHouse().getId().equals(house.getId())) {
                continue;
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            calendar.add(Calendar.DAY_OF_WEEK, app.getDuration());
            Date appEndDate = calendar.getTime();

            if(startDate.after(app.getAppointmentDate()) && endDate.before(appEndDate)) {
                return true;
            }
        }
        return false;
    }
}
