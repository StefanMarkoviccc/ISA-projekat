package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Boat extends BaseEntity{

    private String name;

    private String type;

    private double length;

    private String engineNumber;

    private double enginePower;

    private double maxSpeed;

    private String address;

    private String promotionalDescription;

    private int capacity;

    private String rulesOfConduct;

}
