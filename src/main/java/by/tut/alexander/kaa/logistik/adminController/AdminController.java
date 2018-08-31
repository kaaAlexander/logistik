package by.tut.alexander.kaa.logistik.adminController;

import by.tut.alexander.kaa.logistik.country.service.CountryService;
import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
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


    @GetMapping("/")
    public String findAllCountries(Model model) {
        List<CountryDTO> countryDTOList = countryService.getAllCountries();
        model.addAttribute("countries", countryDTOList);
        return "index";
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
        return "redirect:/";
    }

    @GetMapping("/deleteCountry")
    public String deleteCountryById(@RequestParam("id") Long id) {
        countryService.deleteCountryById(id);
        return "redirect:/";
    }

    @GetMapping("/provinceList")
    public String getProvinceByCountryId(@RequestParam("id") Long id,
                                         @RequestParam("countryName") String countryName,
                                         Model model) {
        List<ProvinceDTO> provinceDTOList = provinceService.getProvinceByCountryId(id);
        model.addAttribute("provinceList", provinceDTOList);
        model.addAttribute("countryId", id);
        model.addAttribute("countryName", countryName);
        return "provinceList";
    }

    @GetMapping("/addProvince")
    public String newProvincePage(@RequestParam("countryId") Long id, Model model) {
        model.addAttribute("province", new ProvinceDTO());
        model.addAttribute("countryId", id);
        return "addProvince";
    }

    @PostMapping("/addProvince")
    public String createNewProvince(@ModelAttribute("province") @Valid ProvinceDTO provinceDTO,
                                    @RequestParam("countryId") Long id, RedirectAttributes redirectAttributes,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addProvince";
        }
        provinceDTO.setCountryId(id);
        provinceService.addProvince(provinceDTO);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/provinceList";
    }
}
