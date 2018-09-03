package by.tut.alexander.kaa.logistik.application;

import by.tut.alexander.kaa.logistik.user.service.UserService;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/index"})
    public String login() {
        return "index";
    }

    @GetMapping("/admin/menu")
    public String success() {
        return "admin/menu";
    }

    @GetMapping("admin/changePassword")
    public String getChangePasswordPage() {
        return "admin/changePassword";
    }

    @PostMapping("/admin/changePassword")
    public String setNewPassword(@RequestParam("newPassword") String pass, @RequestParam("confirmPassword") String confPass) {
        if (pass != "" && pass.equals(confPass)) {
            System.out.println(pass);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername(); //get logged in username
            UserDTO userDTO = userService.getUserByEmail(name);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            pass = passwordEncoder.encode(pass);
            userDTO.setPassword(pass);
            userService.save(userDTO);
        } else {
            return "redirect:changePassword";
        }
        return null;
    }

}
