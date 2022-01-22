package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteAccRequestDTO extends BaseDTO{
    protected String text;
    protected Long userId;
    protected boolean isRejected;


}
