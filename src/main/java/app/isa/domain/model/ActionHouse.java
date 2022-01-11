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
public class ActionHouse extends  BaseEntity{

    private Date dateTo;

    private Date dateFrom;

    @ManyToOne
    private House house;

    @ManyToOne
    private Room room;

    private double price;
}
