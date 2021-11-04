package app.isa.domain.dto;


import app.isa.domain.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseDTO extends BaseDTO{

    protected String name;

    protected String address;

    protected double geographicalWidth;

    protected  double geographicalLength;

    protected String description;

    protected String rulesOfConduct;
}
