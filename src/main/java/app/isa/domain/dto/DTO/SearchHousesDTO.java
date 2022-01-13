package app.isa.domain.dto.DTO;

import app.isa.domain.model.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SearchHousesDTO extends  BaseDTO{

    protected Date startDate;
    protected Date endDate;
}
