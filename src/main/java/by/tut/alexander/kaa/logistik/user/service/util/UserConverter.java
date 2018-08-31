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
        userDTO.setFirstName(user.getFirstName());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setThirdName(user.getThirdName());
        userDTO.setCompanyName(user.getCompanyName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUnp(user.getUnp());
        return userDTO;
    }
}
