package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

public class AdventureDTO extends BaseDTO {

    protected String name;

    protected String address;

    protected Double lagitude;

    protected Double longitude;

    protected String description;

    protected String biography;

    protected String adventurePictures;

    protected int maxNumberOfPeople;

    protected Date adventureAppointment;

    protected String rules;

    protected String fishingEquipment;

    protected boolean isFreeCancelation;

    protected Double cancelationPercent;

    protected String location;

    protected int standing;

    protected String additionalServices;

    protected Double price;


}
