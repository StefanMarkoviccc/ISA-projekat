package app.isa.domain.dto.DTO;


import app.isa.domain.model.Adventure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

public class AdventureReservationDTO extends BaseDTO {

    protected Date dateAndTime;
    protected String place;
    protected Integer duration;
    protected String maximumNumberOfPersons;
    protected String additionalServices;
    protected Double price;

}
