package app.isa.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class BoatDTO extends  BaseDTO{


    protected String name;

    protected String type;

    protected double length;

    protected String engineNumber;

    protected double enginePower;

    protected double maxSpeed;

    protected String address;

    protected String promotionalDescription;

    protected int capacity;

    protected String rulesOfConduct;

    protected String fishingEquipment;
}
