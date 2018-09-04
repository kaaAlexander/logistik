package by.tut.alexander.kaa.logistik.email.controller;

import by.tut.alexander.kaa.logistik.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminEmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/userInfo")
    public String findEmailByUserId(@RequestParam("userId") Long userId, Model model) {
        model.addAttribute("emailList", emailService.getAllEmailByUserId(userId));
        return "admin/user/userInfo";
    }
}