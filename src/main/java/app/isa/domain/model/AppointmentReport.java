package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class AppointmentReport extends BaseEntity{

    private String text;

    @ManyToOne
    private House house;

    @ManyToOne
    private User client;

    @ManyToOne
    private  User owner;

    private boolean blockClient;

    private boolean clientMissReservation;
}
