package app.isa.domain.dto.DTO;


import app.isa.domain.dto.DTO.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseDTO extends BaseDTO {

    protected String name;

    protected String address;

    protected double geographicalWidth;

    protected  double geographicalLength;

    protected String description;

    protected String rulesOfConduct;
}
