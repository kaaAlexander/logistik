package by.tut.alexander.kaa.logistik.user.service.util;

import by.tut.alexander.kaa.logistik.user.repository.model.User;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class UserConverter {

    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setCompanyName(user.getCompanyName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUnp(user.getUnp());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public User convert(UserDTO userDTO) {
        User user = new User();
        user.setCompanyName(userDTO.getCompanyName());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setId(userDTO.getId());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUnp(userDTO.getUnp());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }
}
