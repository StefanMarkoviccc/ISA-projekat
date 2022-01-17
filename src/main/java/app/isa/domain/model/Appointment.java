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
public class Appointment extends BaseEntity{


    @ManyToOne
    private House house;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User client;

    private Date appointmentDate;

    private boolean isAction = false;

    private int duration;

    private int maxPersons;

    private double price;

    private String additionalServices;
}
