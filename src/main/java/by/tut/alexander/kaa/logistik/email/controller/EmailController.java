package by.tut.alexander.kaa.logistik.email.controller;

import by.tut.alexander.kaa.logistik.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/email"})
public class EmailController {

    @Autowired
    EmailService emailService;


    @GetMapping
    @ResponseBody
    boolean sendEmailWithoutAttachments(@RequestParam("userId") Long userId,
                                        @RequestParam("serviceId") Long serviceId) {
        return emailService.sendEmail(userId, serviceId);
    }

    @PostMapping
    void sendEmail(@RequestParam("userId") Long userId,
                   @RequestParam("serviceId") Long serviceId,
                   @RequestParam("file") MultipartFile files) {
        System.out.println("send");
        emailService.sendEmail(userId, serviceId, files);
    }
}
