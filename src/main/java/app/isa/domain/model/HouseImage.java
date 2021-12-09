package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HouseImage extends BaseEntity {

    @Column(columnDefinition = "TEXT", length = 16000)
    private String content;

    @ManyToOne
    private House house;
}
