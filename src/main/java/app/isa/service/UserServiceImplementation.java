package app.isa.service;

import app.isa.config.SecurityUtils;
import app.isa.domain.dto.converters.RegistrationConverter;
import app.isa.domain.dto.DTO.RegistrationDTO;
import app.isa.domain.dto.DTO.UserDTO;
import app.isa.domain.dto.converters.UserConverter;
import app.isa.domain.model.RegistrationStatus;
import app.isa.domain.model.User;
import app.isa.domain.model.UserType;
import app.isa.repository.UserRepository;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getCliens() {
        List<User> users = new ArrayList<User>();

        for(User user: userRepository.findAll())
        {
            if(user.getUserType()==UserType.CLIENT){
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @Override
    public User register(RegistrationDTO registrationDTO, UserType userType) {

        User user = RegistrationConverter.fromDTO(registrationDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserType(userType);
        user.setRegistrationStatus(RegistrationStatus.WAITING);

        return userRepository.save(user);
    }

    @Override
    public User edit(Long id, UserDTO userDTO) {

        Optional<User> user = userRepository.findById(id);

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

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return false;
        }

        user.get().setDeleted(true);
        userRepository.save(user.get());

        return false;
    }

    @Override
    public boolean onAction(Long id) {
       Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            return false;
        }

        user.get().setOnActions(true);
        userRepository.save(user.get());

        return true;

    }

    @Override
    public User getCurrent() {
        String email = SecurityUtils.getCurrentUserLogin().get();

        return userRepository.getByEmail(email);
    }

    @Override
    public User changePassword(String password, Long id) {
        User user = userRepository.getById(id);
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }


}
