package by.tut.alexander.kaa.logistik.user.controller;

import by.tut.alexander.kaa.logistik.user.service.UserService;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    UserService userService;

    @GetMapping("/userList")
    public String findAllCountries(Model model) {
        List<UserDTO> userDTOList = userService.getAllUsers();
        if (userDTOList.isEmpty()) {
            model.addAttribute("resultFalse", true);
        }
        model.addAttribute("userFilter", new UserDTO());
        model.addAttribute("users", userDTOList);
        return "admin/user/userList";
    }

    @PostMapping("/userList")
    public String getUserByEmailAndPhone(@ModelAttribute("userFilter") UserDTO userDTO, Model model) {
        List<UserDTO> userDTOList = new ArrayList<>();
        if (!userDTO.getEmail().equals("") && !userDTO.getPhoneNumber().equals("")) {
            userDTOList = userService.findUserByEmailAndPhoneNumber(userDTO.getEmail(), userDTO.getPhoneNumber());
        }
        if (userDTO.getEmail().equals("") && !userDTO.getPhoneNumber().equals("")) {
            userDTOList = userService.findUserByPhoneNumber(userDTO.getPhoneNumber());
        }
        if (!userDTO.getEmail().equals("") && userDTO.getPhoneNumber().equals("")) {
            userDTOList = userService.findUserByEmail(userDTO.getEmail());
        }
        if (userDTO.getEmail().equals("") && userDTO.getPhoneNumber().equals("")) {
            return "redirect:userList";
        }
        if (userDTOList.isEmpty()) {
            model.addAttribute("resultFalse", true);
        }
        model.addAttribute("users", userDTOList);
        return "admin/user/userList";
    }


}
