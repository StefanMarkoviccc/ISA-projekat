package app.isa.domain.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangePasswordDTO extends BaseDTO {
    protected String password;

}
