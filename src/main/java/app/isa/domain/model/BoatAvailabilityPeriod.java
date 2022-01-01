package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class BoatAvailabilityPeriod extends BaseEntity{

    private Date dateTo;

    private Date dateFrom;

    @ManyToOne
    private Boat boat;
}
