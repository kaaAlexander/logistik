package by.tut.alexander.kaa.logistik.user.service;

import by.tut.alexander.kaa.logistik.user.repository.UserRepository;
import by.tut.alexander.kaa.logistik.user.repository.model.User;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import by.tut.alexander.kaa.logistik.user.service.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    UserConverter userConverter = new UserConverter();

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDTO getUserById(Long id) {
        return userConverter.convert(userRepository.findUserById(id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = userConverter.convert(user);
            userDTO.setPassword(null);
            userDTO.setRole(null);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userConverter.convert(userRepository.findUserByEmail(email));
    }

    @Override
    public void changePassword(UserDTO userDTO) {
        User user = userConverter.convert(userDTO);
        userRepository.save(user);
    }

    @Override
    public Long save(UserDTO userDTO) {
        userDTO.setPassword("");
        userDTO.setRole("ROLE_USER");
        User user = userConverter.convert(userDTO);
        userRepository.save(user);
        Long userId = user.getId();
        return userId;
    }

    @Override
    public List<UserDTO> findUserByEmail(String email) {
        List<User> userList = userRepository.findUsersByEmail(email);
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = userConverter.convert(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> findUserByPhoneNumber(String phoneNumber) {
        List<User> userList = userRepository.findUsersByPhoneNumber(phoneNumber);
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = userConverter.convert(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> findUserByEmailAndPhoneNumber(String email, String phoneNumber) {
        List<User> userList = userRepository.findUsersByEmailAndPhoneNumber(email, phoneNumber);
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = userConverter.convert(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
