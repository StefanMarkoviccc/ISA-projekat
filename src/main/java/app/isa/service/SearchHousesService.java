package app.isa.service;

import app.isa.domain.model.House;

import java.util.Date;
import java.util.List;


public interface SearchHousesService {
    List<House> getBySearchDate(Date startDate, Date endDate);
}
