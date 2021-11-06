package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class BoatAppointment extends BaseEntity{

    @ManyToOne
    private Boat boat;

    private Date date;

    private boolean isAction = false;

    private int duration;

    private int maxPersons;

    private double price;

}
