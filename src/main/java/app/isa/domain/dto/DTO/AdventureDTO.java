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

    protected String description;

    protected String biography;

    protected String adventurePictures;

    protected int maxNumberOfPeople;

    protected Date adventureAppointment;

    protected String rules;

    protected String fishingEquipment;

    protected Boolean isFreeCancelation;

    protected Double cancelationPercent;

    protected Double price;


}
