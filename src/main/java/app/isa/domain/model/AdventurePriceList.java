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

public class AdventurePriceList extends BaseEntity {

    @ManyToOne
    private Adventure adventure;
    private String name;
    private Double price;
    private String description;

}
