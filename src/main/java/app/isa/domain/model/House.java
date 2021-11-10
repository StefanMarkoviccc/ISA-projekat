package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class House extends  BaseEntity{

    @ManyToOne
    private User houseOwner;

    private String name;

    private String address;

    private double geographicalWidth;

    private  double geographicalLength;

    private String description;

    private String rulesOfConduct;

}
