package app.isa.domain.dto;

import app.isa.domain.model.House;
import app.isa.domain.model.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO extends BaseDTO{

    protected Long houseId;

    protected Long roomId;

    protected Date date;

    protected boolean isAction = false;

    protected int duration;

    protected int maxPersons;

    protected  double price;
}
