package by.tut.alexander.kaa.logistik.user.service;

import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface UserService {

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO getUserByEmail(String email);

    void changePassword(UserDTO userDTO);

    Long save(UserDTO userDTO);

    List<UserDTO> findUserByEmail(String email);

    List<UserDTO> findUserByPhoneNumber(String phoneNumber);

    List<UserDTO> findUserByEmailAndPhoneNumber(String email, String phoneNumber);
}
