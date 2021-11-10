package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class PriceList extends BaseEntity{

    private  String serviceName;

    private double price;

    @ManyToOne
    private House house;


}
