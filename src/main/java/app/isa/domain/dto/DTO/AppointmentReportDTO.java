package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
