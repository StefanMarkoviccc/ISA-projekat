package app.isa.domain.dto.DTO;

import app.isa.domain.dto.DTO.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO extends BaseDTO {

    protected String roomNumber;

    protected int numberOfBeds;

    protected Long  houseId;
}
