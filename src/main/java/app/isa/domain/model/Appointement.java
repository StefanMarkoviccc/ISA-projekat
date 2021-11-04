package app.isa.domain.model;

import javax.persistence.ManyToOne;
import java.util.Date;

public class Appointement extends BaseEntity{

    @ManyToOne
    private House house;

    @ManyToOne
    private Room room;

    private Date date;

    private boolean isAction = false;

    private int duration;

    private int maxPersons;

    private double price;
}
