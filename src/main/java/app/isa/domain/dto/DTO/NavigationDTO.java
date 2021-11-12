package app.isa.domain.dto.DTO;

import app.isa.domain.dto.DTO.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NavigationDTO extends BaseDTO {

    protected String name;

    protected Long boatID;
}
