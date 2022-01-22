package app.isa.domain.dto.DTO;

import app.isa.domain.dto.DTO.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class BoatAppointmentDTO extends BaseDTO {

    protected Long boatId;

    protected Long clientId;

    protected Date date;

    protected boolean isAction = false;

    protected int duration;

    protected int maxPersons;

    protected double price;

    protected String additionalServices;

    protected double priceForAction = 0;

    protected boolean isTaken = true;

}
