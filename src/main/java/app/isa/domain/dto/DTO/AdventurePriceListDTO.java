package app.isa.domain.dto.DTO;


import app.isa.domain.model.Adventure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor


public class AdventurePriceListDTO extends BaseDTO {

    protected Adventure adventure;
    protected String name;
    protected Double price;
    protected String description;

}
