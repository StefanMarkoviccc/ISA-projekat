package app.isa.controller;

import app.isa.config.CustomUserDetailsService;
import app.isa.domain.dto.DTO.*;
import app.isa.domain.dto.converters.UserConverter;
import app.isa.domain.model.User;
import app.isa.domain.model.UserType;
import app.isa.security.TokenUtil;
import app.isa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsService customUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenUtil tokenUtils;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<List<UserDTO>>(UserConverter.toDTOList(userService.getList()), HttpStatus.OK);
    }

    @GetMapping(path = "/clients")
    public  ResponseEntity<List<UserDTO>> getClients() {
        return new ResponseEntity<List<UserDTO>>(UserConverter.toDTOList(userService.getCliens()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {

        User user = userService.getUser(id);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.OK);
    }

    @PostMapping(path = "/not-registered")
    public ResponseEntity<UserDTO> registerNotRegistered(@RequestBody RegistrationDTO registrationDTO) {

        User user = userService.register(registrationDTO, UserType.NOT_REGISTERED);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/client")
    public ResponseEntity<UserDTO> registerClient(@RequestBody RegistrationDTO registrationDTO) {

        User user = userService.register(registrationDTO, UserType.CLIENT);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/house-owner")
    public ResponseEntity<UserDTO> registerHouseOwner(@RequestBody RegistrationDTO registrationDTO) {

        User user = userService.register(registrationDTO, UserType.HOUSE_OWNER);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/fishing-instructor")
    public ResponseEntity<UserDTO> registerFishingInstructor(@RequestBody RegistrationDTO registrationDTO) {

        User user = userService.register(registrationDTO, UserType.FISHING_INSTRUCTOR);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/boat-owner")
    public ResponseEntity<UserDTO> registerBoatOwner(@RequestBody RegistrationDTO registrationDTO) {

        User user = userService.register(registrationDTO, UserType.BOAT_OWNER);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/instructor")
    public ResponseEntity<UserDTO> registerInstructor(@RequestBody RegistrationDTO registrationDTO) {

        User user = userService.register(registrationDTO, UserType.INSTRUCTOR);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/administrator")
    public ResponseEntity<UserDTO> registerAdministrator(@RequestBody RegistrationDTO registrationDTO) {

        User user = userService.register(registrationDTO, UserType.ADMINISTRATOR);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDTO> edit(@PathVariable Long id, @RequestBody UserDTO userDTO) {

        User user = userService.edit(id, userDTO);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @GetMapping(path = "/current")
    public ResponseEntity<UserDTO> getCurrent() {

        User user = userService.getCurrent();

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserDTO>(UserConverter.toDTO(user), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if(userService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponceDTO> registerAdministrator(@RequestBody LoginDTO loginDTO) {
        User user = customUserService.findUserByEmail(loginDTO.getEmail());

        if (user == null || !passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        String token = tokenUtils.generateToken(user.getEmail(), user.getRole().toString());
        LoginResponceDTO responseDTO = new LoginResponceDTO();
        responseDTO.setToken(token);
        return new ResponseEntity<LoginResponceDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {

        User user = userService.getCurrent();

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.changePassword(changePasswordDTO.getPassword(), user.getId());

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
