package by.tut.alexander.kaa.logistik.user.service;

import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;

/**
 * Created by GM on 30.08.2018.
 */
public interface UserService {

    UserDTO getUserById(Long id);
}
