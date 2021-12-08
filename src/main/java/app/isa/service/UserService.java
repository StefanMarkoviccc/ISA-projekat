package app.isa.service;

import app.isa.domain.dto.DTO.RegistrationDTO;
import app.isa.domain.dto.DTO.UserDTO;
import app.isa.domain.model.User;
import app.isa.domain.model.UserType;

import java.util.List;

public interface UserService {

    List<User> getList();
    User getUser(Long id);
    User register(RegistrationDTO registrationDTO, UserType userType);
    User edit(Long id, UserDTO userDTO);
    boolean delete(Long id);
    User getCurrent();

}
