package by.tut.alexander.kaa.logistik.application;

import by.tut.alexander.kaa.logistik.user.service.UserService;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;

@Controller
public class AuthorizationController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/index"})
    public String login() {
        return "index";
    }

    @GetMapping(value = {"/admin/menu", "/admin"})
    public String success() {
        return "admin/menu";
    }

    @GetMapping("admin/changePassword")
    public String getChangePasswordPage() {
        return "admin/changePassword";
    }

    @PostMapping("/admin/changePassword")
    public String setNewPassword(@RequestParam("newPassword") String pass, @RequestParam("confirmPassword") String confPass,
                                 Model model) {
        if (pass != "" && pass.equals(confPass)) {
            System.out.println(pass);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();
            UserDTO userDTO = userService.getUserByEmail(name);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            pass = passwordEncoder.encode(pass);
            userDTO.setPassword(pass);
            userService.changePassword(userDTO);
            model.addAttribute("resultTrue", true);
        } else {
            model.addAttribute("resultFalse", true);
        }
        return "admin/changePassword";
    }

}
