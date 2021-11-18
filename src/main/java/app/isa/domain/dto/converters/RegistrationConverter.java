package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.RegistrationDTO;
import app.isa.domain.model.User;

public class RegistrationConverter {

    public static User fromDTO(RegistrationDTO registrationDTO) {

        User user = new User();
        user.setId(registrationDTO.getId());
        user.setEmail(registrationDTO.getEmail());
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setAddress(registrationDTO.getAddress());
        user.setCity(registrationDTO.getCity());
        user.setCountry(registrationDTO.getCountry());
        user.setPassword(registrationDTO.getPassword());

        return user;
    }
}
