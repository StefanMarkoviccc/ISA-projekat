package app.isa.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Adventure  extends BaseEntity {

    private String name;

    private String address;

    private String description;

    private String biography;

    private int maxNumberOfPeople;

    private Date adventureAppointment;

    private String rules;

    private String fishingEquipment;

    private Double price;



}
