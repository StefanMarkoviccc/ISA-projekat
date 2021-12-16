package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoatImageDTO extends BaseDTO{

    protected  String content;

    protected Long  boatId;
}
