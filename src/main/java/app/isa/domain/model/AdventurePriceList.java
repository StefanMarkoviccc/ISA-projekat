package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class AdventurePriceList extends BaseEntity {

    private Adventure adventure;
    private String name;
    private Double price;
    private String description;

}
