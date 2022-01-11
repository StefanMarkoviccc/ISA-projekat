package app.isa.domain.dto.DTO;

import app.isa.domain.model.ComplainType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComplainDTO extends BaseDTO{

    protected String text;
    protected ComplainType complainType;
}
