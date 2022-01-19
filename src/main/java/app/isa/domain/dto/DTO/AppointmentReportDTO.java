package app.isa.domain.dto.DTO;

import app.isa.domain.model.House;
import app.isa.domain.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppointmentReportDTO extends BaseDTO{

    protected String text;

    protected Long houseId;

    protected Long clientId;

    protected Long ownerId;

    protected boolean blockClient;

    protected boolean clientMissReservation;
}
