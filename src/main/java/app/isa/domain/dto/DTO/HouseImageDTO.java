package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseImageDTO extends BaseDTO{

    protected  String content;

    protected Long  houseId;
}
