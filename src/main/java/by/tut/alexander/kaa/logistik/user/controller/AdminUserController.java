package by.tut.alexander.kaa.logistik.user.controller;

import by.tut.alexander.kaa.logistik.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    UserService userService;
}
