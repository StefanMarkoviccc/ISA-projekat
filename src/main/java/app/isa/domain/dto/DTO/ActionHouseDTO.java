package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ActionHouseDTO extends BaseDTO {

    protected Date dateTo;

    protected Date dateFrom;

    protected Long houseId;

    protected Long roomId;

    protected double price;
}
