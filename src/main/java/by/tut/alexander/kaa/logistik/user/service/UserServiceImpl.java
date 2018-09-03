package by.tut.alexander.kaa.logistik.user.service;

import by.tut.alexander.kaa.logistik.user.repository.UserRepository;
import by.tut.alexander.kaa.logistik.user.repository.model.User;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import by.tut.alexander.kaa.logistik.user.service.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userConverter.convert(userRepository.findUserByEmail(email));
    }

    @Override
    public void save(UserDTO userDTO) {
        userRepository.save(userConverter.convert(userDTO));
    }
}
