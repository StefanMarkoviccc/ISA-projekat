package app.isa.domain.dto;


import app.isa.domain.model.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PriceListDTO extends  BaseDTO{

    protected   String serviceName;

    protected double price;

    protected House house;
}
