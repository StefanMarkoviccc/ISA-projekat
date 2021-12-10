package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class AdventureAvailabilityDTO extends BaseDTO{

    protected Long id;

    protected Date formDate;

    protected Date toDate;

    protected Long adventureId;
}
