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

    private String adress;

    private Double lagitude;

    private Double longitude;

    private String description;

    private String biography;

    private String adventurePictures;

    private int maxNumberOfPeople;

    private Date adventureAppointment;

    private String rules;

    private String fishingEquipment;

    private boolean isFreeCancelation;

    private Double cancelationPercent;

    private String location;

    private int standing;

    private String additionalServices;

    private Double price;



}
