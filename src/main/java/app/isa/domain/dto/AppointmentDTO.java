package app.isa.domain.dto;

import app.isa.domain.model.House;
import app.isa.domain.model.Room;

import java.util.Date;

public class AppointmentDTO extends BaseDTO{

    protected House house;

    protected Room room;

    protected Date date;

    protected boolean isAction=false;
}
