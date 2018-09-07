package by.tut.alexander.kaa.logistik.email.controller;

import by.tut.alexander.kaa.logistik.email.service.EmailService;
import by.tut.alexander.kaa.logistik.email.service.ModelDTO.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/email"})
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping
    boolean sendEmail(@RequestParam("userId") Long userId,
                      @RequestParam("serviceId") Long serviceId,
                      @RequestParam("files") MultipartFile[] files,
                      @RequestParam(value = "subject", required = false) String subject,
                      @RequestParam(value = "text", required = false) String text) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setSubject(subject);
        emailDTO.setText(text);
        return emailService.sendEmail(userId, serviceId, files, emailDTO);
    }
}
