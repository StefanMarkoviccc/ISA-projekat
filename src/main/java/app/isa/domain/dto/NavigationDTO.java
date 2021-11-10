package app.isa.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NavigationDTO extends BaseDTO{

    protected String name;

    protected Long boatID;
}
