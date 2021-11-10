package app.isa.domain.dto;

import app.isa.domain.model.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO extends BaseDTO{

    protected String roomNumber;

    protected int numberOfBeds;

    protected Long  houseId;
}
