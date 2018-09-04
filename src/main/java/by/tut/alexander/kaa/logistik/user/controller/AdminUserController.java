package by.tut.alexander.kaa.logistik.user.controller;

import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
import by.tut.alexander.kaa.logistik.user.service.UserService;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    UserService userService;

    @GetMapping("/userList")
    public String findAllCountries(Model model) {
        List<UserDTO> userDTOList = userService.getAllUsers();
        model.addAttribute("users", userDTOList);
        return "admin/user/userList";
    }


}
