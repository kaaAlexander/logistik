package by.tut.alexander.kaa.logistik.exitPoint.controller;

import by.tut.alexander.kaa.logistik.exitPoint.service.ExitPointService;
import by.tut.alexander.kaa.logistik.exitPoint.service.ModelDTO.ExitPointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminExitPointController {

    @Autowired
    private ExitPointService exitPointService;

    @GetMapping("/exitPointList")
    public String getExitPointsList(@RequestParam("provinceId") Long provinceId,
                                    @RequestParam("provinceName") String provinceName,
                                    @RequestParam("countryId") Long countryId,
                                    @RequestParam("countryName") String countryName,
                                    Model model) {
        List<ExitPointDTO> exitPointDTOList = exitPointService.getExitPointByProvinceId(provinceId);
        model.addAttribute("provinceId", provinceId);
        model.addAttribute("provinceName", provinceName);
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", countryName);
        model.addAttribute("exitPoints", exitPointDTOList);
        return "admin/exitPoint/exitPointList";
    }

    @GetMapping("/addExitPoint")
    public String newExitPointPage(Model model, @RequestParam("provinceId") Long provinceId,
                                   @RequestParam("provinceName") String provinceName,
                                   @RequestParam("countryId") Long countryId,
                                   @RequestParam("countryName") String countryName) {
        model.addAttribute("exitPoint", new ExitPointDTO());
        model.addAttribute("provinceId", provinceId);
        model.addAttribute("provinceName", provinceName);
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", countryName);
        return "admin/exitPoint/addExitPoint";
    }

    @PostMapping("/addExitPoint")
    public String createNewExitPoint(@ModelAttribute("exitPoint") ExitPointDTO exitPoint,
                                     @RequestParam("provinceId") Long provinceId,
                                     @RequestParam("provinceName") String provinceName,
                                     @RequestParam("countryId") Long countryId,
                                     @RequestParam("countryName") String countryName,
                                     RedirectAttributes redirectAttributes,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/exitPoint/addExitPoint";
        }
        exitPoint.setProvinceId(provinceId);
        exitPointService.createNewExitPoint(exitPoint);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        redirectAttributes.addAttribute("provinceId", provinceId);
        redirectAttributes.addAttribute("provinceName", provinceName);
        return "redirect:exitPointList";
    }

    @GetMapping("/deleteExitPoint")
    public String deleteExitPointbyId(@RequestParam("exitPointId") Long exitPointId,
                                      @RequestParam("provinceId") Long provinceId,
                                      @RequestParam("provinceName") String provinceName,
                                      @RequestParam("countryId") Long countryId,
                                      @RequestParam("countryName") String countryName,
                                      RedirectAttributes redirectAttributes) {
        exitPointService.deleteById(exitPointId);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        redirectAttributes.addAttribute("provinceId", provinceId);
        redirectAttributes.addAttribute("provinceName", provinceName);
        return "redirect:exitPointList";
    }

}
