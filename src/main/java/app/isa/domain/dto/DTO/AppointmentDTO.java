package app.isa.domain.dto.DTO;

import app.isa.domain.model.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO extends BaseDTO {

    protected Long houseId;

    protected House house;

    protected Long roomId;

    protected Long clientId;

    protected Date date;

    protected boolean isAction = false;

    protected int duration;

    protected int maxPersons;

    protected  double price;
}
