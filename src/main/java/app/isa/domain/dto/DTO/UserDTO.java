package app.isa.domain.dto.DTO;

import app.isa.domain.dto.DTO.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {

    protected String email;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String city;
    protected String country;
    protected String phoneNumber;
}
