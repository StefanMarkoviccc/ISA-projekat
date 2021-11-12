package app.isa.service;

import app.isa.domain.dto.converters.RegistrationConverter;
import app.isa.domain.dto.DTO.RegistrationDTO;
import app.isa.domain.dto.DTO.UserDTO;
import app.isa.domain.dto.converters.UserConverter;
import app.isa.domain.model.RegistrationStatus;
import app.isa.domain.model.User;
import app.isa.domain.model.UserType;
import app.isa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getList() {
        return userRepository.getAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findOne(id);

        if(user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @Override
    public User register(RegistrationDTO registrationDTO, UserType userType) {

        User user = RegistrationConverter.fromDTO(registrationDTO);
        user.setUserType(userType);
        user.setRegistrationStatus(RegistrationStatus.WAITING);

        return userRepository.save(user);
    }

    @Override
    public User edit(Long id, UserDTO userDTO) {

        Optional<User> user = userRepository.findOne(id);

        if(user.isEmpty()) {
            return null;
        }

        User userData = UserConverter.fromDTO(userDTO);

        user.get().setFirstName(userData.getFirstName());
        user.get().setLastName(userData.getLastName());
        user.get().setAddress(userData.getAddress());
        user.get().setCountry(userData.getCountry());
        user.get().setCity(userData.getCity());

        return userRepository.save(user.get());
    }

    @Override
    public boolean delete(Long id) {

        Optional<User> user = userRepository.findOne(id);

        if(user.isEmpty()) {
            return false;
        }

        user.get().setDeleted(true);
        userRepository.save(user.get());

        return false;
    }
}
