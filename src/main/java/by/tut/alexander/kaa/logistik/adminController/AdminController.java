package by.tut.alexander.kaa.logistik.adminController;

import by.tut.alexander.kaa.logistik.country.service.CountryService;
import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
import by.tut.alexander.kaa.logistik.exitPoint.service.ExitPointService;
import by.tut.alexander.kaa.logistik.exitPoint.service.ModelDTO.ExitPointDTO;
import by.tut.alexander.kaa.logistik.province.service.ModelDTO.ProvinceDTO;
import by.tut.alexander.kaa.logistik.province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    CountryService countryService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    ExitPointService exitPointService;


    @GetMapping("/countryList")
    public String findAllCountries(Model model) {
        List<CountryDTO> countryDTOList = countryService.getAllCountries();
        model.addAttribute("countries", countryDTOList);
        return "countryList";
    }

    @GetMapping("/addCountry")
    public String newBookPage(Model model) {
        model.addAttribute("country", new CountryDTO());
        return "addCountry";
    }

    @PostMapping("/addCountry")
    public String createNewBook(@ModelAttribute("country") @Valid CountryDTO countryDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addCountry";
        }
        countryService.addCountry(countryDTO);
        return "redirect:/countryList";
    }

    @GetMapping("/deleteCountry")
    public String deleteCountryById(@RequestParam("countryId") Long id) {
        countryService.deleteCountryById(id);
        return "redirect:countryList";
    }

    @GetMapping("/provinceList")
    public String getProvinceByCountryId(@RequestParam("countryId") Long id, @RequestParam("countryName") String countryName,
                                         Model model) {
        List<ProvinceDTO> provinceDTOList = provinceService.getProvinceByCountryId(id);
        model.addAttribute("provinceList", provinceDTOList);
        model.addAttribute("countryId", id);
        model.addAttribute("countryName", countryName);
        return "provinceList";
    }

    @GetMapping("/addProvince")
    public String newProvincePage(@RequestParam("countryId") Long countryId, @RequestParam("countryName") String countryName, Model model) {
        model.addAttribute("province", new ProvinceDTO());
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", countryName);
        return "addProvince";
    }

    @PostMapping("/addProvince")
    public String createNewProvince(@ModelAttribute("province") @Valid ProvinceDTO provinceDTO,
                                    @RequestParam("countryId") Long countryId,
                                    @RequestParam("countryName") String countryName,
                                    RedirectAttributes redirectAttributes,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addProvince";
        }
        provinceDTO.setCountryId(countryId);
        provinceService.addProvince(provinceDTO);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        return "redirect:provinceList";
    }

    @GetMapping("/deleteProvince")
    public String deleteProvinceById(@RequestParam("provinceId") Long provinceId,
                                     @RequestParam("countryId") Long countryId,
                                     @RequestParam("countryName") String countryName,
                                     RedirectAttributes redirectAttributes) {
        provinceService.deleteProvinceById(provinceId);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        return "redirect:provinceList";
    }

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
        return "exitPointList";
    }

    @GetMapping("/addExitPoint")
    public String newExitPointpage(Model model, @RequestParam("provinceId") Long provinceId,
                                   @RequestParam("provinceName") String provinceName,
                                   @RequestParam("countryId") Long countryId,
                                   @RequestParam("countryName") String countryName) {
        model.addAttribute("exitPoint", new ExitPointDTO());
        model.addAttribute("provinceId", provinceId);
        model.addAttribute("provinceName", provinceName);
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", countryName);
        return "addExitPoint";
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
            return "addExitPoint";
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
