package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DeleteAccRequest extends BaseEntity{

    private String text;
    private Long userId;
    private boolean isRejected;
}
