package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class AdventureReservation extends BaseEntity{

    private Date dateAndTime;
    private String place;
    private Integer duration;
    private String maximumNumberOfPersons;
    private String additionalServices;
    private Double price;

}
