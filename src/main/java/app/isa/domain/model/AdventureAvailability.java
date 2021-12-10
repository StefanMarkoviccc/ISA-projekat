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


public class AdventureAvailability extends BaseEntity {

    private Date fromDate;
    private Date toDate;
    @ManyToOne
    private Adventure adventure;

}
