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
public class Complain extends BaseEntity {

    private Long houseId;
    private String text;
    private ComplainType complainType;
    private Long userId;
}
