package app.isa.service;

import app.isa.domain.model.Boat;
import app.isa.domain.model.House;

import java.util.Date;
import java.util.List;

public interface SearchBoatService {

    List<Boat> getBySearchDate(Date startDate, Date endDate);
    boolean isBoatTaken(Long id, Date startDate, Date endDate);
}
