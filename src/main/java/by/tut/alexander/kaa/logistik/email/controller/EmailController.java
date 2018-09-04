package by.tut.alexander.kaa.logistik.email.controller;

import by.tut.alexander.kaa.logistik.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/email"})
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping
    void sendEmail(@RequestParam("userId") Long userId,
                   @RequestParam("serviceId") Long serviceId) {
        emailService.sendEmail(userId, serviceId);
    }
}
