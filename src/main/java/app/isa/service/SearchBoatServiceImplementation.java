package app.isa.service;

import app.isa.domain.model.*;
import app.isa.repository.BoatAppointmentRepository;
import app.isa.repository.BoatAvailabilityPeriodRepository;
import app.isa.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SearchBoatServiceImplementation implements SearchBoatService{

    @Autowired
    private BoatAvailabilityPeriodRepository boatAvailabilityPeriodRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private BoatAppointmentRepository boatAppointmentRepository;

    @Override
    public List<Boat> getBySearchDate(Date startDate, Date endDate) {
        List<Boat> results = new ArrayList<>();


        for (BoatAvailabilityPeriod hap : boatAvailabilityPeriodRepository.findAll()) {

            System.out.println("==================");
            System.out.println(startDate.after(hap.getDateFrom()));
            System.out.println(endDate.before(hap.getDateTo()));
            System.out.println((startDate.after(hap.getDateFrom()) && endDate.before(hap.getDateTo())));

            if (!(startDate.after(hap.getDateFrom()) && endDate.before(hap.getDateTo()))) {
                continue;
            }

            if (isAlreadyTaken(hap.getBoat(), startDate, endDate)) {
                continue;
            }

            results.add(hap.getBoat());
        }
        return results;
    }

    public boolean isAlreadyTaken(Boat boat, Date startDate, Date endDate) {

        for(BoatAppointment app: boatAppointmentRepository.findAll()) {

            if(!app.getBoat().getId().equals(boat.getId())) {
                continue;
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            calendar.add(Calendar.DAY_OF_WEEK, app.getDuration());
            Date appEndDate = calendar.getTime();

            if(startDate.after(app.getDate()) && endDate.before(appEndDate)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isBoatTaken(Long id, Date startDate, Date endDate) {
        for(BoatAppointment app: boatAppointmentRepository.findAll()) {



            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            calendar.add(Calendar.DAY_OF_WEEK, app.getDuration());
            Date appEndDate = calendar.getTime();

            if(startDate.after(app.getDate()) && endDate.before(appEndDate)) {
                return true;
            }
        }

        for(BoatAvailabilityPeriod period: boatAvailabilityPeriodRepository.findAll()){
            if(!period.getBoat().getId().equals(id)){
                continue;
            }

            Date periodEndDate = period.getDateTo();

            if(startDate.after(period.getDateFrom()) && endDate.before(periodEndDate)) {
                return true;
            }
        }
        return false;
    }
}
