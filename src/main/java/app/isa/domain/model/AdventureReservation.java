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

public class AdventureReservation extends BaseEntity{

    private Date dateAndTime;
}
