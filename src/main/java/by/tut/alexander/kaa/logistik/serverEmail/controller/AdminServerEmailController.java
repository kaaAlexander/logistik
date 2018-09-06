package by.tut.alexander.kaa.logistik.serverEmail.controller;

import by.tut.alexander.kaa.logistik.serverEmail.service.ServerEmailService;
import by.tut.alexander.kaa.logistik.serverEmail.service.modelDTO.ServerEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminServerEmailController {

    @Autowired
    ServerEmailService serverEmailService;

    @GetMapping("/serverEmail")
    public String findAllServerEmail(Model model) {
        List<ServerEmailDTO> serverEmailDTOList = serverEmailService.getAllServerEmail();
        model.addAttribute("serverEmailList", serverEmailDTOList);
        return "admin/serverEmail/serverEmailList";
    }


    @GetMapping("/deleteServerEmail")
    public String deleteServerEmailById(@RequestParam("emailId") Long id) {
        serverEmailService.deleteServerEmail(id);
        return "redirect:serverEmail";
    }

    @GetMapping("/addServerEmail")
    public String newServerEmailPage(Model model) {
        model.addAttribute("serverEmail", new ServerEmailDTO());
        return "admin/serverEmail/addServerEmail";
    }

    @PostMapping("/addServerEmail")
    public String createNewBook(@ModelAttribute("serverEmail") ServerEmailDTO serverEmailDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/serverEmail/addServerEmail";
        }
        serverEmailService.addServerEmail(serverEmailDTO);
        return "redirect:serverEmail";
    }
}
