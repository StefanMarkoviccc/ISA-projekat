package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Navigation extends BaseEntity{

    private String name;

    @ManyToOne
    private Boat boat;
}
