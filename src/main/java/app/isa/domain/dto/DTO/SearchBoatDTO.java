package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class SearchBoatDTO extends BaseDTO{

    protected Date startDate;
    protected Date endDate;
}
