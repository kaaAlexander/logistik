package by.tut.alexander.kaa.logistik.user.controller;

import by.tut.alexander.kaa.logistik.user.service.UserService;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@RestController
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    Long createNewUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }
}
