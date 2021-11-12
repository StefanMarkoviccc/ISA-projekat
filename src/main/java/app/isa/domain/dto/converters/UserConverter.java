package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.UserDTO;
import app.isa.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static User fromDTO(UserDTO userDTO) {

        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setCountry(userDTO.getCountry());

        return user;
    }

    public static UserDTO toDTO(User user){

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity());
        userDTO.setCountry(user.getCountry());

        return userDTO;
    }

    public static List<UserDTO> toDTOList(List<User> users){
        ArrayList<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (User user : users) {
            userDTOList.add(toDTO(user));
        }

        return userDTOList;
    }
}
