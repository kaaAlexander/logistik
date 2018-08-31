package by.tut.alexander.kaa.logistik.user.service;

import by.tut.alexander.kaa.logistik.user.repository.UserRepository;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import by.tut.alexander.kaa.logistik.user.service.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GM on 30.08.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    UserConverter userConverter = new UserConverter();

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long id) {
        return userConverter.convert(userRepository.findUserById(id));
    }
}
